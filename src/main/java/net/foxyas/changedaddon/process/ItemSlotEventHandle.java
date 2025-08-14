package net.foxyas.changedaddon.process;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ItemSlotEventHandle {
    /*
    @SubscribeEvent
    public static void onArmorEquip(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            EquipmentSlot slot = event.getSlot();
            ItemStack from = event.getFrom();
            ItemStack to = event.getTo();
            LatexVariantInstance<?> latexVariantInstance = ProcessTransfur.getPlayerLatexVariant(player);
            if (slot.getType() == EquipmentSlot.Type.ARMOR) {
                if (to.getItem() instanceof HazmatSuitItem) {
                    if (latexVariantInstance != null){
                        player.setItemSlot(slot, from);
                        player.getInventory().add(to);
                    }
                }
            }
        }
    }
    
*/

   /*@SubscribeEvent
   * public static void onPlayerRightClick(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getPlayer();
        ItemStack itemStack = event.getItemStack();
        TransfurVariantInstance<?> latexVariantInstance = ProcessTransfur.getPlayerTransfurVariant(player);
        if (itemStack.getItem() instanceof HazmatSuitItem) {
            if (latexVariantInstance != null){
                event.setCanceled(true);
            }
        }
    }
*/
}
