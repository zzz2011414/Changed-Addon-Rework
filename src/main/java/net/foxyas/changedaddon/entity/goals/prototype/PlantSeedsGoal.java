package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.foxyas.changedaddon.init.ChangedAddonSounds;
import net.ltxprogrammer.changed.entity.Emote;
import net.ltxprogrammer.changed.init.ChangedParticles;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class PlantSeedsGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;
    private final int searchRange = 6;
    private BlockPos targetPos;

    public PlantSeedsGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (entity.isInventoryEmpty() && entity.getMainHandItem().isEmpty() && entity.getOffhandItem().isEmpty())
            return false;

        // Check if entity has any seed in inventory
        for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
            ItemStack stack = entity.getInventory().getItem(i);
            if (isSeed(stack)) {
                // Look for farmland with air above to plant
                targetPos = findPlantableFarmland(entity.getLevel(), entity.blockPosition(), searchRange);
                if (targetPos != null) {
                    return true;
                }
            }
        }

        ItemStack mainHandItem = entity.getMainHandItem();
        ItemStack offHandItem = entity.getOffhandItem();
        if (isSeed(mainHandItem) || isSeed(offHandItem)) {
            // Look for farmland with air above to plant
            targetPos = findPlantableFarmland(entity.getLevel(), entity.blockPosition(), searchRange);
            return targetPos != null;
        }

        return false;
    }

    @Override
    public void start() {
        if (targetPos != null) {
            entity.getLevel().playSound(null, entity.blockPosition(), ChangedAddonSounds.PROTOTYPE_IDEA, SoundSource.MASTER, 1, 1);
            if (entity.getLevel().isClientSide) {
                entity.getLevel().addParticle(
                        ChangedParticles.emote(entity, Emote.IDEA),
                        entity.getX(),
                        entity.getY() + (double) entity.getDimensions(entity.getPose()).height + 0.65,
                        entity.getZ(),
                        0.0f,
                        0.0f,
                        0.0f
                );
            }
            navigation.moveTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, 0.25f);
        }
    }

    @Override
    public void tick() {
        if (targetPos == null) return;

        if (entity.blockPosition().closerThan(targetPos, 1.5)) {
            plantSeedAt(targetPos);
            targetPos = null; // reset target after planting
        } else {
            navigation.moveTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, 0.25f);
        }
    }

    private boolean isSeed(ItemStack stack) {
        // Check if the item is a seed (BlockItem and the block is a CropBlock)
        if (stack.isEmpty()) return false;
        if (!(stack.getItem() instanceof BlockItem blockItem)) return false;
        Block block = blockItem.getBlock();
        return block instanceof CropBlock;
    }

    private BlockPos findPlantableFarmland(Level level, BlockPos center, int range) {
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-range, -1, -range),
                center.offset(range, 1, range))) {
            BlockState soil = level.getBlockState(pos);
            BlockState above = level.getBlockState(pos.above());

            if (soil.getBlock() == Blocks.FARMLAND && above.isAir()) {
                return pos.above();
            }
        }
        return null;
    }

    private void plantSeedAt(BlockPos pos) {
        Level level = entity.getLevel();
        for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
            ItemStack stack = entity.getInventory().getItem(i);
            if (isSeed(stack)) {
                if (!level.isClientSide()) {
                    // Place the crop block at target position
                    this.entity.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(pos.getX(), pos.getY(), pos.getZ()));
                    entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
                    Block block = ((BlockItem) stack.getItem()).getBlock();
                    level.setBlock(pos, block.defaultBlockState(), 3);
                    stack.shrink(1);
                    break;
                }
                break;
            }
        }
    }
}
