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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class DepositToChestGoal extends Goal {

    private final PrototypeEntity entity;
    private final PathNavigation navigation;

    private BlockPos targetChestPos;

    public DepositToChestGoal(PrototypeEntity entity) {
        this.entity = entity;
        this.navigation = entity.getNavigation();
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Use only if we have a target chest and inventory is not empty
        targetChestPos = entity.getTargetChestPos();
        return targetChestPos != null;
    }

    @Override
    public boolean isInterruptable() {
        return false;
    }

    @Override
    public void start() {
        if (targetChestPos != null) {
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
            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.35f);
        }
    }

    @Override
    public void tick() {
        if (targetChestPos != null && entity.blockPosition().closerThan(targetChestPos, 2.0)) {
            if (entity.getLevel() instanceof ServerLevel serverLevel) {
                depositToChest(serverLevel, targetChestPos);
            }
            entity.setTargetChestPos(null); // Reset target after deposit
        } else if (targetChestPos != null) {
            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.35f);
        }
    }

    @Override
    public boolean canContinueToUse() {
        return targetChestPos != null && !entity.getInventory().isEmpty() && entity.blockPosition().closerThan(targetChestPos, 2.0);
    }

    private void depositToChest(ServerLevel level, BlockPos chestPos) {
        BlockEntity be = level.getBlockEntity(chestPos);

        if (be instanceof ChestBlockEntity chest) {
            for (int i = 0; i < entity.getInventory().getContainerSize() + 1; i++) {
                ItemStack stack = entity.getInventory().getItem(i);
                if (!stack.isEmpty()) {
                    this.entity.lookAt(EntityAnchorArgument.Anchor.FEET, new Vec3(chestPos.getX(), chestPos.getY(), chestPos.getZ()));
                    entity.swing(entity.isLeftHanded() ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND);
                    ItemStack remaining = HopperBlockEntity.addItem(null, chest, stack, null);
                    chest.setChanged();
                    entity.getInventory().setItem(i, remaining);
                    entity.getInventory().setChanged();
                }
            }
        }
    }
}
