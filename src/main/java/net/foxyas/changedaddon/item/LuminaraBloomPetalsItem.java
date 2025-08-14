package net.foxyas.changedaddon.item;

import net.foxyas.changedaddon.init.ChangedAddonTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class LuminaraBloomPetalsItem extends Item {
    public LuminaraBloomPetalsItem() {
        super(new Properties().tab(ChangedAddonTabs.TAB_CHANGED_ADDON).rarity(Rarity.UNCOMMON));
    }
}
