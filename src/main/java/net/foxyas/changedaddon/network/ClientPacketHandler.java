package net.foxyas.changedaddon.network;

import net.foxyas.changedaddon.network.packets.ClientboundOpenFTKCScreenPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ClientPacketHandler {

    public static void handleOpenFTKCScreenPacket(ClientboundOpenFTKCScreenPacket packet, Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> Minecraft.getInstance().setScreen(packet.minigameType().screen.get()));
        context.setPacketHandled(true);
    }
}
