package net.foxyas.changedaddon.entity.interfaces;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public interface CustomPatReaction {
    default void WhenPattedReaction() {
    }

    default void WhenPattedReaction(Player patter) {
    }

    default void WhenPattedReaction(Player patter, Vec3 pattedLocation) {
    }

    default void WhenPatEvent(LivingEntity patter, LivingEntity patTarget) {

    }
}
