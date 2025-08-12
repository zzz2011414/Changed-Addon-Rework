package net.foxyas.changedaddon.entity.simple;

import net.foxyas.changedaddon.entity.defaults.AbstractBasicChangedEntity;
import net.foxyas.changedaddon.entity.goals.prototype.DepositToChestGoal;
import net.foxyas.changedaddon.entity.goals.prototype.FindAndHarvestCropsGoal;
import net.foxyas.changedaddon.entity.goals.prototype.FindChestGoal;
import net.foxyas.changedaddon.entity.goals.prototype.GrabCropsGoal;
import net.foxyas.changedaddon.init.ChangedAddonEntities;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.EyeStyle;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.entity.variant.TransfurVariant;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.Tags;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class PrototypeEntity extends AbstractBasicChangedEntity implements MenuProvider {

    // Our internal inventory (9 slots)
    private final SimpleContainer inventory = new SimpleContainer(9) {
        @Override
        public void setChanged() {
            super.setChanged();
        }
    };

    public static final int MAX_HARVEST = 10;
    private int harvestsDone = 0;

    @Nullable
    private BlockPos targetChestPos = null;

    public PrototypeEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedAddonEntities.PROTOTYPE.get(), world);
    }

    public PrototypeEntity(EntityType<PrototypeEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setPersistenceRequired();
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = ChangedEntity.createLatexAttributes();
        builder = builder.add(ChangedAttributes.TRANSFUR_DAMAGE.get(), 0f);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 24);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 16);
        return builder;
    }

    protected void setAttributes(AttributeMap attributes) {
        Objects.requireNonNull(attributes.getInstance(ChangedAttributes.TRANSFUR_DAMAGE.get())).setBaseValue(0);
        attributes.getInstance(Attributes.MAX_HEALTH).setBaseValue(24);
        attributes.getInstance(Attributes.FOLLOW_RANGE).setBaseValue(40.0f);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.05f);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(0.95f);
        attributes.getInstance(Attributes.ATTACK_DAMAGE).setBaseValue(3.0f);
        attributes.getInstance(Attributes.ARMOR).setBaseValue(0);
        attributes.getInstance(Attributes.ARMOR_TOUGHNESS).setBaseValue(0);
        attributes.getInstance(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(0);
    }

    // Save inventory
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("Inventory", inventory.createTag());
        tag.putInt("harvestDone", this.harvestsDone);

        if (targetChestPos != null) {
            CompoundTag nbt = new CompoundTag();
            nbt.putInt("targetX", targetChestPos.getX());
            nbt.putInt("targetY", targetChestPos.getY());
            nbt.putInt("targetZ", targetChestPos.getZ());

            tag.put("TargetChestPos", nbt);
        }
    }

    // Load inventory
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        inventory.fromTag(tag.getList("Inventory", 10));
        if (tag.contains("harvestDone")) {
            this.harvestsDone = tag.getInt("harvestsDone");
        }

        if (tag.contains("TargetChestPos")) {
            CompoundTag nbt = tag.getCompound("TargetChestPos");
            int x = nbt.getInt("targetX");
            int y = nbt.getInt("targetY");
            int z = nbt.getInt("targetZ");
            this.targetChestPos = new BlockPos(x, y, z);
        }
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    protected boolean targetSelectorTest(LivingEntity livingEntity) {
        return false;
    }

    @Override
    public boolean tryTransfurTarget(Entity entity) {
        return false;
    }

    @Override
    public boolean tryAbsorbTarget(LivingEntity target, IAbstractChangedEntity source, float amount, @Nullable List<TransfurVariant<?>> possibleMobFusions) {
        return false;
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.NONE;
    }

    @Override
    public boolean canTakeItem(ItemStack pItemstack) {
        if (pItemstack.is(Tags.Items.CROPS) || pItemstack.is(Tags.Items.SEEDS)) {
            return true;
        }
        return super.canTakeItem(pItemstack);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(10, new FindAndHarvestCropsGoal(this));
        this.goalSelector.addGoal(10, new GrabCropsGoal(this));
        this.goalSelector.addGoal(10, new FindChestGoal(this));
        this.goalSelector.addGoal(10, new DepositToChestGoal(this));
    }

    public boolean isInventoryFull() {
        for (int i = 0; i < inventory.getContainerSize(); i++) {
            if (inventory.getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public void addToInventory(ItemStack stack) {

        // Only store crop-related items
        if (!stack.is(Tags.Items.CROPS) || !stack.is(Tags.Items.SEEDS)) {
            return;
        }

        for (int i = 0; i < getInventory().getContainerSize(); i++) {
            ItemStack slot = getInventory().getItem(i);
            if (slot.isEmpty()) {
                getInventory().setItem(i, stack.copy());
                stack.setCount(0);
                return;
            } else if (ItemStack.isSameItemSameTags(slot, stack)) {
                int canAdd = Math.min(slot.getMaxStackSize() - slot.getCount(), stack.getCount());
                slot.grow(canAdd);
                stack.shrink(canAdd);
                if (stack.isEmpty()) return;
            }
        }
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return super.getTransfurColor(cause);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(@NotNull ServerLevelAccessor pLevel, @NotNull DifficultyInstance pDifficulty, @NotNull MobSpawnType pReason, @Nullable SpawnGroupData pSpawnData, @Nullable CompoundTag pDataTag) {
        SpawnGroupData ret = super.finalizeSpawn(pLevel, pDifficulty, pReason, pSpawnData, pDataTag);
        this.getBasicPlayerInfo().setEyeStyle(EyeStyle.TALL);
        return ret;
    }

    @Override
    public @NotNull InteractionResult interactAt(@NotNull Player player, @NotNull Vec3 vec, @NotNull InteractionHand hand) {
        if (!getLevel().isClientSide && player.isShiftKeyDown()) {
            player.openMenu(getMenuProvider());
            return InteractionResult.CONSUME; // we handled it
        }
        return super.interactAt(player, vec, hand);
    }

    @Override
    public void baseTick() {
        super.baseTick();
    }

    // MenuProvider — for opening GUI
    private final MenuProvider menuProvider = new MenuProvider() {
        @Override
        public @NotNull Component getDisplayName() {
            return PrototypeEntity.this.getDisplayName();
        }

        @Override
        public @Nullable AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
            return PrototypeEntity.this.createMenu(i, inventory, player);
        }
    };

    public MenuProvider getMenuProvider() {
        return menuProvider;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return this.getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory playerInventory, @NotNull Player player) {
        return new ChestMenu(MenuType.GENERIC_9x1, id, playerInventory, this.inventory, 1);
    }

    // Public accessor
    public SimpleContainer getInventory() {
        return inventory;
    }

    public int getHarvestsDone() {
        return this.harvestsDone;
    }

    public @Nullable BlockPos getTargetChestPos() {
        return targetChestPos;
    }

    public void setTargetChestPos(@Nullable BlockPos targetChestPos) {
        this.targetChestPos = targetChestPos;
    }
}
