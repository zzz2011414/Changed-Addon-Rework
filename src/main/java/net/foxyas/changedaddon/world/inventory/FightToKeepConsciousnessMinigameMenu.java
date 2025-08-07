
package net.foxyas.changedaddon.world.inventory;

import net.foxyas.changedaddon.client.gui.FightToKeepConsciousnessMinigameScreen;
import net.foxyas.changedaddon.init.ChangedAddonMenus;
import net.foxyas.changedaddon.procedures.FightTokeepconsciousnessminigameThisGUIIsClosedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FightToKeepConsciousnessMinigameMenu extends AbstractContainerMenu {

	public final Level world;
	public final Player entity;
	public FightToKeepConsciousnessMinigameScreen.MinigameType minigameType;

	public FightToKeepConsciousnessMinigameMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(ChangedAddonMenus.FIGHT_TO_KEEP_CONSCIOUSNESS_MINIGAME, id);
		this.entity = inv.player;
		this.world = inv.player.level;
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

		FightTokeepconsciousnessminigameThisGUIIsClosedProcedure.execute(world, entity);
	}
}
