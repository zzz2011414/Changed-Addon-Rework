package net.foxyas.changedaddon.entity.advanced;

import net.foxyas.changedaddon.entity.defaults.AbstractBasicOrganicChangedEntity;
import net.foxyas.changedaddon.init.ChangedAddonEntities;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.util.Mth.lerp;

public class BorealisFemaleEntity extends AbstractBasicOrganicChangedEntity {
    public BorealisFemaleEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public BorealisFemaleEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedAddonEntities.BOREALIS_FEMALE.get(), world);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor p_21434_, @NotNull DifficultyInstance p_21435_, @NotNull MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        return super.finalizeSpawn(p_21434_, p_21435_, p_21436_, p_21437_, p_21438_);
    }

    @Override
    public TransfurMode getTransfurMode() {
        return this.getRandom().nextBoolean() ? TransfurMode.ABSORPTION : TransfurMode.REPLICATION;
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        Color3 firstColor = Color3.parseHex("#6682C1");
        Color3 secondColor = Color3.parseHex("1C2A4E");
        if (firstColor != null && secondColor != null) {
            return lerpColors(firstColor, secondColor);
        }

        return firstColor;
    }

    public Color3 getDripColor() {
        return Color3.WHITE;
    }
}
