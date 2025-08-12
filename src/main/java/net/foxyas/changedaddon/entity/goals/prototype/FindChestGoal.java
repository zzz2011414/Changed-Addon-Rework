package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class FindChestGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;
    private BlockPos targetChestPos;

    private final int searchRange = 8;

    public FindChestGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Use only if inventory full or max harvests reached, and a chest exists nearby
        if ((entity.isInventoryFull() || entity.getHarvestsDone() >= PrototypeEntity.MAX_HARVEST)) {
            BlockPos chest = findNearbyChest(entity.getLevel(), entity.blockPosition(), searchRange);
            if (chest != null) {
                targetChestPos = chest;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void start() {
        this.entity.setTargetChestPos(targetChestPos);
//        if (targetChestPos != null) {
//            this.entity.setTargetChestPos(targetChestPos);
//            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.25f);
//        }
    }

    @Override
    public void tick() {
        this.entity.setTargetChestPos(targetChestPos);
        // Just keep moving towards chest
//        if (targetChestPos != null && !entity.blockPosition().closerThan(targetChestPos, 2.0)) {
//            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.25f);
//        }
    }

    @Override
    public boolean canContinueToUse() {
        // Continue until close to chest
        return targetChestPos != null && !entity.blockPosition().closerThan(targetChestPos, 2.0);
    }

    @Override
    public void stop() {
        this.entity.setTargetChestPos(targetChestPos);
        targetChestPos = null;
    }

    private BlockPos findNearbyChest(Level level, BlockPos center, int range) {
        List<ItemStack> carriedItems = new ArrayList<>();
        for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
            ItemStack stack = entity.getInventory().getItem(i);
            if (!stack.isEmpty()) carriedItems.add(stack);
        }

        // First try to find chest containing at least one matching item
        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-range, -range, -range), center.offset(range, range, range))) {
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
                                    return pos.immutable();
                                }
                            }
                        }
                    }
                }
            }
        }

        // Otherwise return any chest
        for (BlockPos pos : BlockPos.betweenClosed(center.offset(-range, -range, -range), center.offset(range, range, range))) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof ChestBlockEntity) return pos.immutable();
        }

        return null;
    }
}
