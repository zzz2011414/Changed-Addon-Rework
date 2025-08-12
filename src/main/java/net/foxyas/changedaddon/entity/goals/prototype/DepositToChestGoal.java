package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.HopperBlockEntity;

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
    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void start() {
        if (targetChestPos != null) {
            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.35f);
        }
    }

    @Override
    public void tick() {
        if (targetChestPos != null && entity.blockPosition().closerThan(targetChestPos, 2.0)) {
            depositToChest((ServerLevel) entity.getLevel(), targetChestPos);
            entity.setTargetChestPos(null); // Reset target after deposit
        } else if (targetChestPos != null) {
            navigation.moveTo(targetChestPos.getX() + 0.5, targetChestPos.getY(), targetChestPos.getZ() + 0.5, 0.35f);
        }
    }

    @Override
    public boolean canContinueToUse() {
        return targetChestPos != null && !entity.getInventory().isEmpty() && !entity.blockPosition().closerThan(targetChestPos, 2.0);
    }

    private void depositToChest(ServerLevel level, BlockPos chestPos) {
        BlockEntity be = level.getBlockEntity(chestPos);
        if (be instanceof ChestBlockEntity chest) {
            for (int i = 0; i < entity.getInventory().getContainerSize(); i++) {
                ItemStack stack = entity.getInventory().getItem(i);
                if (!stack.isEmpty()) {
                    ItemStack remaining = HopperBlockEntity.addItem(entity.getInventory(), chest, stack, null);
                    entity.getInventory().setItem(i, remaining);
                }
            }
        }
    }
}
