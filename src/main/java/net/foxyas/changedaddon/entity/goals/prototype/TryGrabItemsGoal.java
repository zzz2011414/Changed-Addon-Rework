package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.advanced.PrototypeEntity;
import net.foxyas.changedaddon.init.ChangedAddonSounds;
import net.ltxprogrammer.changed.entity.Emote;
import net.ltxprogrammer.changed.init.ChangedParticles;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;

public class TryGrabItemsGoal extends Goal {

    private final PrototypeEntity prototype;

    public TryGrabItemsGoal(PrototypeEntity entity) {
        this.prototype = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Only run if there is at least one item nearby to pick up
        List<ItemEntity> nearbyItems = prototype.getLevel().getEntitiesOfClass(ItemEntity.class,
                prototype.getBoundingBox().inflate(16.0),
                item -> !item.getItem().isEmpty());
        return !nearbyItems.isEmpty() && !prototype.isInventoryFull();
    }

    @Override
    public boolean requiresUpdateEveryTick() {
        return true; // We want to check every tick while active
    }

    @Override
    protected int adjustedTickDelay(int pAdjustment) {
        return super.adjustedTickDelay(0);
    }

    @Override
    public void start() {
        super.start();

        List<ItemEntity> nearbyItems = prototype.getLevel().getEntitiesOfClass(ItemEntity.class,
                prototype.getBoundingBox().inflate(16.0),
                item -> !item.getItem().isEmpty());

        if (nearbyItems.isEmpty()) {
            return;
        }

        ItemEntity closestItem = nearbyItems.stream().filter((itemEntity) -> {
                    ItemStack stack = itemEntity.getItem();
                    return prototype.canTakeItem(stack);
                })
                .min((i1, i2) -> Double.compare(i1.distanceToSqr(prototype), i2.distanceToSqr(prototype)))
                .orElse(null);

        if (closestItem != null) {
            prototype.getLevel().playSound(null, prototype.blockPosition(), ChangedAddonSounds.PROTOTYPE_IDEA, SoundSource.MASTER, 1, 1);
            if (prototype.getLevel().isClientSide) {
                prototype.getLevel().addParticle(
                        ChangedParticles.emote(prototype, Emote.IDEA),
                        prototype.getX(),
                        prototype.getY() + (double) prototype.getDimensions(prototype.getPose()).height + 0.65,
                        prototype.getZ(),
                        0.0f,
                        0.0f,
                        0.0f
                );
            }
            prototype.getNavigation().moveTo(closestItem, 0.25f);
            prototype.lookAt(EntityAnchorArgument.Anchor.FEET, closestItem.position().subtract(0, 1,0));
        }
    }

    @Override
    public void tick() {
        super.tick();

//        // Se chegou perto o suficiente do item, pegar
//        List<ItemEntity> nearbyItems = prototype.getLevel().getEntitiesOfClass(ItemEntity.class,
//                prototype.getBoundingBox().inflate(2.0),
//                item -> !item.getItem().isEmpty());
//
//        for (ItemEntity itemEntity : nearbyItems) {
//            if (prototype.distanceTo(itemEntity) < 2.0) {
//                prototype.addToInventory(itemEntity.getItem());
//                if (itemEntity.getItem().isEmpty()) {
//                    itemEntity.discard();
//                }
//            }
//        }
    }

}
