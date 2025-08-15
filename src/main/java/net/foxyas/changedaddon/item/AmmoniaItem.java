package net.foxyas.changedaddon.item;

import net.foxyas.changedaddon.init.ChangedAddonTabs;
import net.foxyas.changedaddon.procedures.AmmoniaItemIsCraftedsmeltedProcedure;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AmmoniaItem extends Item {
    public AmmoniaItem() {
        super(new Item.Properties().tab(ChangedAddonTabs.TAB_CHANGED_ADDON).stacksTo(64).rarity(Rarity.COMMON));
    }

    @Override
    public void onCraftedBy(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Player entity) {
        super.onCraftedBy(itemstack, world, entity);
        AmmoniaItemIsCraftedsmeltedProcedure.execute(entity);
    }
}
