package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.foxyas.changedaddon.init.ChangedAddonSounds;
import net.ltxprogrammer.changed.entity.Emote;
import net.ltxprogrammer.changed.init.ChangedParticles;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class FindAndHarvestCropsGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;
    private static final int searchRange = 8;
    private BlockPos targetCropPos;

    public FindAndHarvestCropsGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Can only harvest if inventory not full and there's a mature crop nearby
        return (!entity.isInventoryFull() && entity.getHarvestsTimes() < PrototypeEntity.MAX_HARVEST) && findNearbyCrop(entity.getLevel(), entity.blockPosition(), searchRange) != null;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        targetCropPos = findNearbyCrop(entity.getLevel(), entity.blockPosition(), searchRange);
        if(targetCropPos == null) return;

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
        navigation.moveTo(targetCropPos.getX() + 0.5, targetCropPos.getY(), targetCropPos.getZ() + 0.5, 0.25f);
    }

    @Override
    public void tick() {
        Level level = entity.getLevel();

        if (targetCropPos != null) {
            if (entity.blockPosition().closerThan(targetCropPos, 2.0)) {
                harvestCrop((ServerLevel) level, targetCropPos);

                // Look at crop and swing arm
                entity.lookAt(EntityAnchorArgument.Anchor.FEET, Vec3.atCenterOf(targetCropPos));
                entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);

                targetCropPos = null; // Reset to find new crop next tick
                return;
            }

            navigation.moveTo(targetCropPos.getX() + 0.5, targetCropPos.getY(), targetCropPos.getZ() + 0.5, 0.25f);
            return;
        }

        // No crop found, try again next tick
        targetCropPos = findNearbyCrop(level, entity.blockPosition(), searchRange);
        if (targetCropPos != null) {
            navigation.moveTo(targetCropPos.getX() + 0.5, targetCropPos.getY(), targetCropPos.getZ() + 0.5, 0.25f);
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
        if(!(state.getBlock() instanceof CropBlock crop) || !crop.isMaxAge(state)) return;

        // Drop items naturally (simulate player breaking)
        Block.dropResources(state, level, pos, null);
        // Replant at age 0
        level.setBlock(pos, crop.getStateForAge(0), 3);
        level.playSound(null, pos, state.getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1, 1);
        entity.addHarvestsTime();
    }
}
