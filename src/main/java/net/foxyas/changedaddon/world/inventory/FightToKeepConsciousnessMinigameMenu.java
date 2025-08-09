
package net.foxyas.changedaddon.world.inventory;

import net.foxyas.changedaddon.client.gui.FightToKeepConsciousnessMinigameScreen;
import net.foxyas.changedaddon.init.ChangedAddonKeyMappings;
import net.foxyas.changedaddon.init.ChangedAddonMenus;
import net.foxyas.changedaddon.network.ChangedAddonModVariables;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

public class FightToKeepConsciousnessMinigameMenu extends AbstractContainerMenu {

	public final Level level;
	public final Player player;
	public FightToKeepConsciousnessMinigameScreen.MinigameType minigameType;

	public FightToKeepConsciousnessMinigameMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ChangedAddonMenus.FIGHT_TO_KEEP_CONSCIOUSNESS_MINIGAME, id);
		this.player = inv.player;
		this.level = inv.player.level;
		this.minigameType = FightToKeepConsciousnessMinigameScreen.MinigameType.getRandom(inv.player.getRandom());
        extraData.readBlockPos();
	}

	@Override
	public boolean stillValid(@NotNull Player player) {
		return true;
	}

	@Override
	public void removed(@NotNull Player playerIn) {
		super.removed(playerIn);

        if(!level.isClientSide) return;

        ChangedAddonModVariables.PlayerVariables vars = ChangedAddonModVariables.PlayerVariables.of(player);
        if(vars == null) return;

        if(!vars.consciousnessFightGiveUp && vars.consciousnessFightProgress >= 25){//TODO replace the .replace("(KEY)") with %1$s in lang files
            String Msg = (new TranslatableComponent("changedaddon.warn.close_fight_to_keep_consciousness").getString()).replace("(KEY)",
                    GLFW.glfwGetKeyName(ChangedAddonKeyMappings.OPEN_STRUGGLE_MENU.getKey().getValue(), GLFW.glfwGetKeyScancode(ChangedAddonKeyMappings.OPEN_STRUGGLE_MENU.getKey().getValue())));
            player.displayClientMessage(new TextComponent(Msg), true);
        }
	}
}
