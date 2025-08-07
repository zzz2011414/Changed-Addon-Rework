
package net.foxyas.changedaddon.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record FightToKeepConsciousnessMinigameButtonMessage(int buttonID, double progress) {

	public FightToKeepConsciousnessMinigameButtonMessage(FriendlyByteBuf buf) {
		this(buf.readVarInt(), buf.readDouble());
	}

	public static void buffer(FightToKeepConsciousnessMinigameButtonMessage message, FriendlyByteBuf buf) {
		buf.writeVarInt(message.buttonID);
		buf.writeDouble(message.progress);
	}

	public static void handler(FightToKeepConsciousnessMinigameButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			double progress = message.progress;
			handleButtonAction(entity, buttonID, progress);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player player, int buttonID, double progress) {
		if(player == null) return;

		ChangedAddonModVariables.PlayerVariables vars = player.getCapability(ChangedAddonModVariables.PLAYER_VARIABLES_CAPABILITY).resolve().orElse(null);
		if(vars == null) return;

		if (buttonID == 0) {
			vars.consciousnessFightProgress += progress;
			vars.syncPlayerVariables(player);

			if(vars.consciousnessFightProgress >= 25) player.closeContainer();
		}

		if (buttonID == 1) {
			if(!player.level.isClientSide) player.displayClientMessage(new TextComponent((new TranslatableComponent("changedaddon.fight_concience.give_up").getString())), true);

			vars.consciousnessFightGiveUp = true;
			vars.syncPlayerVariables(player);

			player.closeContainer();
		}
	}
}
