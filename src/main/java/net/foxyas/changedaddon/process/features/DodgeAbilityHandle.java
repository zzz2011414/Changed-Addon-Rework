package net.foxyas.changedaddon.process.features;

import net.foxyas.changedaddon.init.ChangedAddonAbilities;
import net.foxyas.changedaddon.abilities.DodgeAbilityInstance;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DodgeAbilityHandle {

    @SubscribeEvent
    public static void onEntityAttacked(LivingAttackEvent event) {
        LivingEntity target = event.getEntityLiving();
        Entity attacker = event.getSource().getEntity();

        if (!(target instanceof Player player) || attacker == null)
            return;

        Level world = target.level;

        TransfurVariantInstance<?> variant = ProcessTransfur.getPlayerTransfurVariant(player);
        if (variant == null)
            return;

        DodgeAbilityInstance dodge = (DodgeAbilityInstance) variant.abilityInstances.get(ChangedAddonAbilities.DODGE.get());
        if (dodge == null)
            return;

        if (!dodge.isDodgeActive())
            return;

        if (dodge.getDodgeAmount() <= 0) {
            dodge.getController().deactivateAbility();
            return;
        }

        if (attacker instanceof LivingEntity livingAttacker) {
            applyDodgeEffects(player, livingAttacker, dodge, world, event);
            applyDodgeHandle(player, livingAttacker, dodge, world, event);
        }
    }

    //Keep this method for mixins
    private static void applyDodgeEffects(Player player, LivingEntity attacker, DodgeAbilityInstance dodge, LevelAccessor levelAccessor, LivingAttackEvent event) {
        dodge.executeDodgeEffects(levelAccessor, attacker, player, event);
    }

    private static void applyDodgeHandle(Player player, LivingEntity attacker, DodgeAbilityInstance dodge, LevelAccessor levelAccessor, LivingAttackEvent event) {
        dodge.executeDodgeHandle(levelAccessor, attacker, player, event, true);
    }


    public static void dashBackwards(Player target, boolean includeY) {
        Vec3 look = target.getLookAngle().normalize();
        Vec3 motion = look.scale(1.25);
        Vec3 finalMotion = includeY ?
                new Vec3(-motion.x, target.getDeltaMovement().y, -motion.z) :
                target.getDeltaMovement().add(-motion.x, 0, -motion.z);

        target.setDeltaMovement(finalMotion);
    }

    public static void dashInFacingDirection(LivingEntity target) {
        double yaw = Math.toRadians(target.getYRot());
        double pitch = Math.toRadians(target.getXRot());
        double x = -Math.sin(yaw);
        double y = -Math.sin(pitch);
        double z = Math.cos(yaw);
        double speed = 1.05;

        Vec3 motion = new Vec3(x * speed, y * speed, z * speed);
        target.setDeltaMovement(target.getDeltaMovement().add(motion));
    }

    private static void dodgeAwayFromAttacker(Entity dodger, Entity attacker) {
        Vec3 motion = attacker.position().subtract(dodger.position()).scale(-0.25);
        dodger.setDeltaMovement(motion.x, dodger.getDeltaMovement().y, motion.z);
    }
}
