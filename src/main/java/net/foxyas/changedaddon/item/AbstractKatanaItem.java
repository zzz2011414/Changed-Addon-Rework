package net.foxyas.changedaddon.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.ltxprogrammer.changed.init.ChangedEffects;
import net.ltxprogrammer.changed.init.ChangedParticles;
import net.ltxprogrammer.changed.init.ChangedSounds;
import net.ltxprogrammer.changed.item.SpecializedItemRendering;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractKatanaItem extends TieredItem implements SpecializedItemRendering {
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public AbstractKatanaItem(Tier tier, float pAttackDamageModifier, float pAttackSpeedModifier, Item.Properties pProperties) {
        super(tier, pProperties);
        this.attackDamage = pAttackDamageModifier + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", pAttackSpeedModifier, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    /*@Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }*/

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getAttributeModifiers(slot, stack);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        if (entity instanceof Player player) {
            var Variant = ProcessTransfur.getPlayerTransfurVariant(player);
            if (Variant != null && Variant.canWear(player, new ItemStack(Items.DIAMOND_HELMET), EquipmentSlot.HEAD)) {
                return true;
            }
        }

        return super.canEquip(stack, armorType, entity);
    }


    @Override
    public boolean hurtEnemy(@NotNull ItemStack itemstack, @NotNull LivingEntity entity, @NotNull LivingEntity sourceentity) {
        boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
        applyShockEffect(entity, sourceentity);
        return retval;
    }

    @Override
    public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
        boolean retval = super.onEntitySwing(itemstack, entity);
        return retval;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity target) {
        boolean retVal = super.onLeftClickEntity(stack, player, target);
        if (retVal && player.getAttackStrengthScale(1) >= 0.9f) {
            spawnElectricSwingParticle(player, 2f);
        }
        return retVal;
    }

    @Override
    public @NotNull AABB getSweepHitBox(@NotNull ItemStack stack, @NotNull Player player, @NotNull Entity target) {
        return super.getSweepHitBox(stack, player, target);
    }

    public static void applyShockEffect(Entity entity, Entity sourceentity) {
        if (entity == null) {
            return;
        }
        LivingEntity enemy = (LivingEntity) entity;
        ChangedSounds.broadcastSound(enemy, ChangedSounds.PARALYZE1, 1.0F, 1.0F);
        enemy.addEffect(new MobEffectInstance(ChangedEffects.SHOCK, 6, 0, false, false, true));
    }

    public void spawnElectricSwingParticle(LivingEntity source, float attackRange) {
        if (source == null) {
            return;
        }
        double d0 = (double) (-Mth.sin(source.getYRot() * 0.017453292F)) * attackRange;
        double d1 = (double) Mth.cos(source.getYRot() * 0.017453292F) * attackRange;
        Level var7 = source.level;
        if (var7 instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ChangedParticles.TSC_SWEEP_ATTACK, source.getX() + d0, source.getY(0.5), source.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }

    }
}
