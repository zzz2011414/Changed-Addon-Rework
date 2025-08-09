package net.foxyas.changedaddon.client.gui.ftkc;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.network.ChangedAddonModVariables;
import net.foxyas.changedaddon.network.FightToKeepConsciousnessMinigameButtonMessage;
import net.foxyas.changedaddon.util.RenderUtil;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_NEED;
import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_TIME;

public class KeyPressMinigameScreen extends Screen {

    private static final ResourceLocation BACKGROUND_TEXTURE = ChangedAddonMod.textureLoc(
            "textures/screens/qtes/fight_to_keep_consciousness/fight_to_keep_consciousness_minigame");
    private static final int imageWidth = 200;
    private static final int halfImgWidth = imageWidth / 2;
    private static final int imageHeight = 166;
    private static final int halfImgHeight = imageHeight / 2;

    private final Player player;
    private final Button button_fight;
    private final Button button_give_up;

    public KeyPressMinigameScreen() {
        super(TextComponent.EMPTY);
        minecraft = Minecraft.getInstance();
        player = minecraft.player;

        button_fight = new Button(0, 0, 166, 20,
                new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_fight"),
                e -> {
                    //ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 1));
                    //FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 0, 1);
                }
        );

        button_give_up = new Button(0, 0, 166, 20,
                new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_give_up"),
                e -> {
                    ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(1, 1));
                    FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 1, 1);
                }
        );
    }

    @Override
    protected void init() {
        super.init();

        int halfWidth = width / 2;
        int halfHeight = height / 2;

        button_fight.x = halfWidth - button_fight.getWidth() / 2;
        button_fight.y = halfHeight - button_fight.getHeight() - 20;

        button_give_up.x = halfWidth - button_give_up.getWidth() / 2;
        button_give_up.y = halfHeight + button_give_up.getHeight() + 20;

        addRenderableWidget(button_fight);
        addRenderableWidget(button_give_up);
    }

    @Override
    public void render(@NotNull PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        renderBackground(poseStack);

        int halfWidth = width / 2;
        int halfHeight = height / 2;

        super.render(poseStack, mouseX, mouseY, partialTick);

        RenderUtil.drawCentered(font, poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(player)), halfWidth, halfHeight - 50, -12829636);
        RenderUtil.drawCentered(font, poseStack, getProgressText(player), halfWidth, halfHeight + 7, -12829636);
    }

    @Override
    public void renderBackground(@NotNull PoseStack poseStack) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
        blit(poseStack, width / 2 - halfImgWidth, height / 2 - halfImgHeight, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        RenderSystem.disableBlend();
    }

    /* ----------------------------- STATIC METHODS ----------------------------- */
    public static String getProgressText(@NotNull Player entity) {
        return ChangedAddonModVariables.PlayerVariables.ofOrDefault(entity)
                .consciousnessFightProgress + "/" + STRUGGLE_NEED;
    }

    public static String getTimeRemaining(@NotNull Player player) {
        TransfurVariantInstance<?> transfurInstance = ProcessTransfur.getPlayerTransfurVariant(player);

        return transfurInstance == null ? "" : String.valueOf(transfurInstance.ageAsVariant / STRUGGLE_TIME);
    }
}
