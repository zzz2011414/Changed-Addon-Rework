package net.foxyas.changedaddon.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CatalyzerBlockIllustrativeItemItem extends Item {
    public CatalyzerBlockIllustrativeItemItem() {
        super(new Item.Properties().tab(null).stacksTo(1).rarity(Rarity.RARE));
    }
}
