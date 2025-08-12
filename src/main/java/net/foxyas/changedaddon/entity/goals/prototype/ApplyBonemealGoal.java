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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class ApplyBonemealGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;
    private final int searchRange = 6;
    private BlockPos targetPos;

    public ApplyBonemealGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        if (!hasBonemeal()) return false;

        // Find a growable crop nearby
        targetPos = findGrowableCrop(entity.getLevel(), entity.blockPosition(), searchRange);
        return targetPos != null;
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
            applyBonemeal(targetPos);
            targetPos = null; // reset target after applying
        } else {
            navigation.moveTo(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5, 0.25f);
        }
    }

    private boolean hasBonemeal() {
        for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
            ItemStack stack = entity.getInventory().getItem(i);
            if (!stack.isEmpty() && stack.getItem() == Items.BONE_MEAL) {
                return true;
            }
        }

        return entity.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.BONE_MEAL)
                || entity.getItemBySlot(EquipmentSlot.OFFHAND).is(Items.BONE_MEAL);
    }

    private BlockPos findGrowableCrop(Level level, BlockPos center, int range) {
        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-range, -1, -range),
                center.offset(range, 1, range))) {
            BlockState state = level.getBlockState(pos);
            Block block = state.getBlock();

            if (block instanceof BonemealableBlock fertilizable && fertilizable.isValidBonemealTarget(level, pos, state, level.isClientSide())) {
                return pos.immutable();
            }
        }
        return null;
    }

    private void applyBonemeal(BlockPos pos) {
        Level level = entity.getLevel();

        if (!entity.getMainHandItem().is(Items.BONE_MEAL) && !entity.getOffhandItem().is(Items.BONE_MEAL)) {
            for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
                ItemStack stack = entity.getInventory().getItem(i);
                if (stack.getItem() == Items.BONE_MEAL) {
                    if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
                        BlockState state = level.getBlockState(pos);
                        Block block = state.getBlock();

                        if (block instanceof BonemealableBlock fertilizable) {
                            if (fertilizable.isValidBonemealTarget(level, pos, state, false)) {
                                this.entity.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(pos.getX(), pos.getY(), pos.getZ()));
                                entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
                                fertilizable.performBonemeal(serverLevel, level.getRandom(), pos, state);
                                serverLevel.levelEvent(1505, targetPos, 1); // Bone meal particles
                                stack.shrink(1);
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        } else {
            ItemStack stack = entity.getMainHandItem().is(Items.BONE_MEAL) ? entity.getMainHandItem() : entity.getOffhandItem();
            if (stack.getItem() == Items.BONE_MEAL) {
                if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
                    BlockState state = level.getBlockState(pos);
                    Block block = state.getBlock();

                    if (block instanceof BonemealableBlock fertilizable) {
                        if (fertilizable.isValidBonemealTarget(level, pos, state, false)) {
                            this.entity.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(pos.getX(), pos.getY(), pos.getZ()));
                            entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
                            fertilizable.performBonemeal(serverLevel, level.getRandom(), pos, state);
                            serverLevel.levelEvent(1505, targetPos, 1); // Bone meal particles
                            stack.shrink(1);
                        }
                    }
                }
            }
        }
    }
}
