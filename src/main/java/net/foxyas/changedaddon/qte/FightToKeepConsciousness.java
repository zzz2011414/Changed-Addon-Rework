package net.foxyas.changedaddon.qte;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.gui.ftkc.KeyPressMinigameScreen;
import net.foxyas.changedaddon.client.gui.ftkc.MouseCirclePullMinigameScreen;
import net.foxyas.changedaddon.client.gui.ftkc.MousePullMinigameScreen;
import net.foxyas.changedaddon.init.ChangedAddonGameRules;
import net.foxyas.changedaddon.network.ChangedAddonModVariables;
import net.foxyas.changedaddon.network.packets.ClientboundOpenFTKCScreenPacket;
import net.foxyas.changedaddon.procedures.SummonEntityProcedure;
import net.foxyas.changedaddon.util.PlayerUtil;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLLoader;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.ApiStatus;

import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class FightToKeepConsciousness {

    public static final int STRUGGLE_TIME = 100;
    public static final int STRUGGLE_NEED = 25;

    @SubscribeEvent
    public static void onPlayerTransfur(ProcessTransfur.KeepConsciousEvent event) {
        if(!(event.player instanceof ServerPlayer player) //|| event.shouldKeepConscious //FIXME uncomment after testing is done
                || !player.level.getGameRules().getBoolean(ChangedAddonGameRules.FIGHT_TO_KEEP_CONSCIOUSNESS)) return;

        event.shouldKeepConscious = true;

        MinigameType minigameType = MinigameType.getRandom(player.getRandom());
        updatePlayerVariables(ChangedAddonModVariables.PlayerVariables.ofOrDefault(player), minigameType, 0, player);

        ChangedAddonMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new ClientboundOpenFTKCScreenPacket(minigameType));
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.phase != TickEvent.Phase.END || !(event.player instanceof ServerPlayer player)) return;

        if(!player.isAlive()) return;

        TransfurVariantInstance<?> instance = ProcessTransfur.getPlayerTransfurVariant(player);
        ChangedAddonModVariables.PlayerVariables vars = ChangedAddonModVariables.PlayerVariables.ofOrDefault(player);

        if(vars.FTKCminigameType == null) return;

        if(instance == null){
            FightToKeepConsciousness.successFTKC(vars, player);
            return;
        }

        if (instance.ageAsVariant >= STRUGGLE_TIME) {

            if (vars.consciousnessFightProgress >= STRUGGLE_NEED) {
                successFTKC(vars, player);
                return;
            }

            failFTKC(vars, player);
        }
    }

    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        Entity entity = event.getEntity();
        if(!(entity instanceof ServerPlayer player)) return;

        TransfurVariantInstance<?> instance = ProcessTransfur.getPlayerTransfurVariant(player);
        ChangedAddonModVariables.PlayerVariables vars = ChangedAddonModVariables.PlayerVariables.ofOrDefault(player);

        if(instance == null || vars.FTKCminigameType == null) return;

        vars.FTKCminigameType = null;
        vars.syncPlayerVariables(player);

        PlayerUtil.UnTransfurPlayer(entity);
    }

    private static void updatePlayerVariables(ChangedAddonModVariables.PlayerVariables vars, MinigameType minigameType, int progress, Entity entity) {
        vars.FTKCminigameType = minigameType;
        vars.consciousnessFightProgress = progress;
        vars.syncPlayerVariables(entity);
    }

    @ApiStatus.Internal
    public static void successFTKC(ChangedAddonModVariables.PlayerVariables vars, ServerPlayer player){
        player.displayClientMessage(new TranslatableComponent("changedaddon.fight_conscience.success"), true);

        updatePlayerVariables(vars, null, 0, player);
    }

    @ApiStatus.Internal
    public static void failFTKC(ChangedAddonModVariables.PlayerVariables vars, ServerPlayer player){
        player.displayClientMessage(new TranslatableComponent("changedaddon.fight_conscience.fail"), true);

        SummonEntityProcedure.execute(player.level, player);
        PlayerUtil.UnTransfurPlayer(player);

        player.hurt(new DamageSource("conscience_lose").bypassArmor(), Float.MAX_VALUE);
        updatePlayerVariables(vars, null, 0, player);
    }

    public enum MinigameType {//Just in case do not replace lambda with method reference
        MOUSE_PULL(3.5f, FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new MousePullMinigameScreen()),
        MOUSE_CIRCLE_PULL(4.2f, FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new MouseCirclePullMinigameScreen()),
        KEY_PRESS(1, FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new KeyPressMinigameScreen());

        public final Supplier<Screen> screen;
        public final float progressAmount;

        MinigameType(float progressAmount, Supplier<Screen> supplier){
            this.screen = supplier;
            this.progressAmount = progressAmount;
        }

        public static MinigameType getRandom(Random random) {
            return values()[random.nextInt(values().length)];
        }
    }
}
