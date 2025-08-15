package net.foxyas.changedaddon.item;

import net.foxyas.changedaddon.init.ChangedAddonTabs;
import net.foxyas.changedaddon.procedures.SignalBlockFeatureProcedure;
import net.foxyas.changedaddon.procedures.SignalCatcherOnPlayerStoppedUsingProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SignalCatcherItem extends Item {
    public SignalCatcherItem() {
        super(new Item.Properties().tab(ChangedAddonTabs.TAB_CHANGED_ADDON).stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public int getUseDuration(@NotNull ItemStack itemstack) {
        return 15;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player entity, @NotNull InteractionHand hand) {
        InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
        ItemStack itemstack = ar.getObject();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        entity.startUsingItem(hand);
        return ar;
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();

        SignalBlockFeatureProcedure.execute(world, x, y, z, entity, itemstack);
        return retval;
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull LivingEntity entity, int time) {
        SignalCatcherOnPlayerStoppedUsingProcedure.execute(entity, itemstack);
    }
}
