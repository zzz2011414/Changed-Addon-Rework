package net.foxyas.changedaddon.mixins.entity.projectiles;

import net.foxyas.changedaddon.abilities.DodgeAbilityInstance;
import net.foxyas.changedaddon.init.ChangedAddonAbilities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Mixin(Projectile.class)
public abstract class ProjectileMixin {

    @Shadow
    @Nullable
    public abstract Entity getOwner();

    @Inject(method = "canHitEntity", at = @At("HEAD"), cancellable = true)
    private void ignoreDodgingEntities(Entity pTarget, CallbackInfoReturnable<Boolean> cir) {
        Entity owner = this.getOwner();

        if (pTarget instanceof ChangedEntity changedEntity) {

            DodgeAbilityInstance dodgeAbilityInstance = changedEntity.getAbilityInstance(ChangedAddonAbilities.DODGE.get());
            DodgeAbilityInstance teleportDodgeAbilityInstance = changedEntity.getAbilityInstance(ChangedAddonAbilities.DODGE.get());
            if (dodgeAbilityInstance != null
                    && dodgeAbilityInstance.canUse()
                    && dodgeAbilityInstance.canKeepUsing()
                    && dodgeAbilityInstance.isDodgeActive()) {
                if (owner instanceof LivingEntity livingOwner && changedEntity.invulnerableTime <= 0) {
                    dodgeAbilityInstance.executeDodgeEffects(changedEntity, livingOwner);
                    dodgeAbilityInstance.executeDodgeHandle(changedEntity, livingOwner);
                }
                cir.setReturnValue(false);
            } else if (teleportDodgeAbilityInstance != null
                    && teleportDodgeAbilityInstance.canUse()
                    && teleportDodgeAbilityInstance.canKeepUsing()
                    && teleportDodgeAbilityInstance.isDodgeActive()) {
                if (owner instanceof LivingEntity livingOwner && changedEntity.invulnerableTime <= 0) {
                    teleportDodgeAbilityInstance.executeDodgeEffects(changedEntity, livingOwner);
                    teleportDodgeAbilityInstance.executeDodgeHandle(changedEntity, livingOwner);
                }
                cir.setReturnValue(false);
            }

        }
        if (pTarget instanceof Player player) {
            TransfurVariantInstance<?> instance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (instance != null) {
                DodgeAbilityInstance dodgeAbilityInstance = instance.getAbilityInstance(ChangedAddonAbilities.DODGE.get());
                DodgeAbilityInstance teleportDodgeAbilityInstance = instance.getAbilityInstance(ChangedAddonAbilities.DODGE.get());
                if (dodgeAbilityInstance != null
                        && dodgeAbilityInstance.canUse()
                        && dodgeAbilityInstance.canKeepUsing()
                        && dodgeAbilityInstance.isDodgeActive()) {
                    if (owner instanceof LivingEntity livingOwner && player.invulnerableTime <= 0) {
                        dodgeAbilityInstance.executeDodgeEffects(player, livingOwner);
                        dodgeAbilityInstance.executeDodgeHandle(player, livingOwner);
                    }
                    cir.setReturnValue(false);
                } else if (teleportDodgeAbilityInstance != null
                        && teleportDodgeAbilityInstance.canUse()
                        && teleportDodgeAbilityInstance.canKeepUsing()
                        && teleportDodgeAbilityInstance.isDodgeActive()) {
                    if (owner instanceof LivingEntity livingOwner && player.invulnerableTime <= 0) {
                        teleportDodgeAbilityInstance.executeDodgeEffects(player, livingOwner);
                        teleportDodgeAbilityInstance.executeDodgeHandle(player, livingOwner);
                    }
                    cir.setReturnValue(false);
                }
            }

        }
    }
}
