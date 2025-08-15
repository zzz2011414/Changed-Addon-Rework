package net.foxyas.changedaddon.item;

import net.foxyas.changedaddon.init.ChangedAddonTabs;
import net.foxyas.changedaddon.procedures.SpawneggoffoxyasRightclickedProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;
import org.jetbrains.annotations.NotNull;

public class SpawnEggOfFoxyasItem extends Item {
    public SpawnEggOfFoxyasItem() {
        super(new Item.Properties().tab(ChangedAddonTabs.TAB_CHANGED_ADDON).stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemstack) {
        return UseAnim.BLOCK;
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext context) {
        super.useOn(context);
        SpawneggoffoxyasRightclickedProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
        return InteractionResult.SUCCESS;
    }
}
