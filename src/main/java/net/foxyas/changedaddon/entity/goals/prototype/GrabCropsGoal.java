package net.foxyas.changedaddon.entity.goals.prototype;

import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.foxyas.changedaddon.init.ChangedAddonSounds;
import net.ltxprogrammer.changed.entity.Emote;
import net.ltxprogrammer.changed.init.ChangedParticles;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.Tags;

import java.util.EnumSet;
import java.util.List;

public class GrabCropsGoal extends Goal {

    private final PrototypeEntity prototype;

    public GrabCropsGoal(PrototypeEntity entity) {
        this.prototype = entity;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        // Only run if there is at least one item nearby to pick up
        List<ItemEntity> nearbyItems = prototype.getLevel().getEntitiesOfClass(ItemEntity.class,
                prototype.getBoundingBox().inflate(8.0),
                item -> !item.getItem().isEmpty());
        return !nearbyItems.isEmpty();
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

        // Buscar itens próximos não vazios
        List<ItemEntity> nearbyItems = prototype.getLevel().getEntitiesOfClass(ItemEntity.class,
                prototype.getBoundingBox().inflate(8.0), // alcance maior pra buscar
                item -> !item.getItem().isEmpty());

        if (nearbyItems.isEmpty()) {
            return; // nada para fazer
        }

        // Encontrar o item mais próximo
        ItemEntity closestItem = nearbyItems.stream().filter((itemEntity) -> {
                    ItemStack stack = itemEntity.getItem();
                    return stack.is(Tags.Items.CROPS) || stack.is(Tags.Items.SEEDS);
                })
                .min((i1, i2) -> Double.compare(i1.distanceTo(prototype), i2.distanceTo(prototype)))
                .orElse(null);

        if (closestItem != null) {
            // Mandar ir até o item mais próximo com velocidade 0.5 (ajuste como quiser)
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
