package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class HarvestCropsGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;
    private final SimpleContainer inventory; // entity's inventory

    private BlockPos targetCropPos;
    private BlockPos targetChestPos;
    private int harvestsDone = 0;

    public final int maxHarvests = 10;
    private final int searchRange = 8;

    public HarvestCropsGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.inventory = entity.getInventory();
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Start if inventory is full and there is a chest nearby
        // OR if inventory is not full and there is a fully-grown crop nearby
        return entity.isInventoryFull() && findNearbyChest(this.entity.getLevel(), entity.blockPosition(), searchRange) != null
                || (!entity.isInventoryFull() && findNearbyCrop(entity.getLevel(), entity.blockPosition(), searchRange) != null);
    }

    @Override
    public boolean canContinueToUse() {
        return super.canContinueToUse();
    }

    @Override
    public void start() {
        harvestsDone = 0;
        targetCropPos = null;
        targetChestPos = null;
    }

    @Override
    public void tick() {
        Level level = entity.getLevel();

        // If inventory is not full and no crop target is set, search for one
        if (targetCropPos == null && !entity.isInventoryFull()) {
            targetCropPos = findNearbyCrop(level, entity.blockPosition(), searchRange);
            if (targetCropPos != null) {
                navigation.moveTo(targetCropPos.getX() + 0.5, targetCropPos.getY(), targetCropPos.getZ() + 0.5, 1.0);
            }
        }

        // If close enough to the crop, harvest it
        if (targetCropPos != null && entity.blockPosition().closerThan(targetCropPos, 2.0)) {
            harvestCrop((ServerLevel) level, targetCropPos);
            harvestsDone++;

            // Look at the position where it harvested
            this.entity.lookAt(EntityAnchorArgument.Anchor.FEET, Vec3.atCenterOf(targetCropPos));
            this.entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

            // Try to pick up nearby dropped items
            level.getEntitiesOfClass(ItemEntity.class,
                    entity.getBoundingBox().inflate(2.0),
                    item -> !item.getItem().isEmpty()
            ).forEach(itemEntity -> {
                addToInventory(itemEntity.getItem());
                if (itemEntity.getItem().isEmpty()) {
                    itemEntity.discard(); // Remove from world if fully picked up
                }
            });
        }

        // If inventory is full or max harvest count reached, search for a chest
        if ((entity.isInventoryFull() || harvestsDone >= maxHarvests) && targetChestPos == null) {
            targetChestPos = findNearbyChest(level, entity.blockPosition(), searchRange);
            if (targetChestPos != null) {
                navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 1.0);
            }
        }

        // If close enough to the chest, deposit items
        if (targetChestPos != null && entity.blockPosition().closerThan(targetChestPos, 2.0)) {
            depositToChest((ServerLevel) level, targetChestPos);
            targetChestPos = null;
            harvestsDone = 0; // Ready for a new harvesting round
        }
    }

    private BlockPos findNearbyCrop(Level level, BlockPos center, int range) {
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-range, -range, -range),
                center.offset(range, range, range))) {
            BlockState state = level.getBlockState(pos);
            if (state.getBlock() instanceof CropBlock crop) {
                if (crop.isMaxAge(state)) {
                    return pos.immutable();
                }
            }
        }
        return null;
    }

    private void harvestCrop(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof CropBlock crop && crop.isMaxAge(state)) {
            // Drop items naturally (like a player breaking it)
            Block.dropResources(state, level, pos, null);

            // Replant crop at age 0
            level.setBlock(pos, crop.getStateForAge(0), 3);
        }
    }


    private BlockPos findNearbyChest(Level level, BlockPos center, int range) {
        // Get all items currently carried by the entity
        List<ItemStack> carriedItems = new ArrayList<>();
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack stack = inventory.getItem(i);
            if (!stack.isEmpty()) {
                carriedItems.add(stack);
            }
        }

        // --- FIRST SEARCH: chest with at least one matching item ---
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-range, -range, -range),
                center.offset(range, range, range))) {

            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ChestBlockEntity chest) {
                LazyOptional<IItemHandler> chestCap = chest.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
                IItemHandler chestInv = chestCap.orElse(null);
                if (chestInv != null) {
                    for (int slot = 0; slot < chestInv.getSlots(); slot++) {
                        ItemStack chestItem = chestInv.getStackInSlot(slot);
                        if (!chestItem.isEmpty()) {
                            for (ItemStack carried : carriedItems) {
                                if (ItemStack.isSameItemSameTags(carried, chestItem)) {
                                    return pos.immutable(); // Found a chest with a matching item
                                }
                            }
                        }
                    }
                }
            }
        }

        // --- SECOND SEARCH: any chest ---
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-range, -range, -range),
                center.offset(range, range, range))) {

            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ChestBlockEntity) {
                return pos.immutable();
            }
        }

        return null; // No chest found
    }

    private void depositToChest(ServerLevel level, BlockPos chestPos) {
        BlockEntity be = level.getBlockEntity(chestPos);
        if (be instanceof ChestBlockEntity chest) {
            for (int i = 0; i < inventory.getContainerSize(); i++) {
                ItemStack stack = inventory.getItem(i);
                if (!stack.isEmpty()) {
                    // Try to move items from entity inventory to chest
                    ItemStack remaining = HopperBlockEntity.addItem(inventory, chest, stack, null);
                    inventory.setItem(i, remaining);
                }
            }
        }
    }

    private void addToInventory(ItemStack stack) {

        if (!stack.is(Tags.Items.SEEDS) ) {
            return;
        }

        // Only store crop-related items
        if (!(stack.getItem() instanceof ItemNameBlockItem itemBlock) || !(itemBlock.getBlock() instanceof CropBlock)) {
            return; // Ignore non-crop items
        }

        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack slot = inventory.getItem(i);
            if (slot.isEmpty()) {
                inventory.setItem(i, stack.copy());
                stack.setCount(0);
                return;
            } else if (ItemStack.isSameItemSameTags(slot, stack)) {
                int canAdd = Math.min(slot.getMaxStackSize() - slot.getCount(), stack.getCount());
                slot.grow(canAdd);
                stack.shrink(canAdd);
                if (stack.isEmpty()) return;
            }
        }
    }

}
