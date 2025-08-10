package net.foxyas.changedaddon.client.gui;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.gui.ftkc.KeyPressMinigameScreen;
import net.foxyas.changedaddon.client.gui.ftkc.MouseCirclePullMinigameScreen;
import net.foxyas.changedaddon.client.gui.ftkc.MousePullMinigameScreen;
import net.foxyas.changedaddon.mixins.client.MouseHandlerAccessor;
import net.foxyas.changedaddon.network.ChangedAddonModVariables;
import net.foxyas.changedaddon.network.FightToKeepConsciousnessMinigameButtonMessage;
import net.foxyas.changedaddon.util.GeometryUtil;
import net.foxyas.changedaddon.world.inventory.FightToKeepConsciousnessMinigameMenu;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.fml.loading.FMLLoader;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.function.Supplier;

import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_NEED;
import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_TIME;

public class FightToKeepConsciousnessMinigameScreen extends AbstractContainerScreen<FightToKeepConsciousnessMinigameMenu> {

    /* ----------------------------- ENUM ----------------------------- */
    public enum MinigameType {//Just in case do not replace lambda with method reference
        MOUSE_PULL(FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new MousePullMinigameScreen()),
        MOUSE_CIRCLE_PULL(FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new MouseCirclePullMinigameScreen()),
        KEY_PRESS(FMLLoader.getDist().isDedicatedServer() ? () -> null : () -> new KeyPressMinigameScreen());

        public final Supplier<Screen> screen;

        MinigameType(Supplier<Screen> supplier){
            this.screen = supplier;
        }

        public static MinigameType getRandom(Random random) {
            return values()[random.nextInt(values().length)];
        }
    }

    /* ----------------------------- CONSTANTS ----------------------------- */
    private static final ResourceLocation BACKGROUND_TEXTURE = ChangedAddonMod.textureLoc(
            "textures/screens/qtes/fight_to_keep_consciousness/fight_to_keep_consciousness_minigame");
    public static final ResourceLocation CIRCLE_SLOT = ChangedAddonMod.textureLoc(
            "textures/screens/qtes/fight_to_keep_consciousness/struggle_circle_slot");
    public static final ResourceLocation CIRCLE_CURSOR = ChangedAddonMod.textureLoc(
            "textures/screens/qtes/fight_to_keep_consciousness/struggle_circle_cursor");

    private static final float INTERACTION_RADIUS = 15f;

    /* ----------------------------- VARIABLES ----------------------------- */
    protected final Minecraft minecraft = Minecraft.getInstance();
    private final Player player;
    public final MinigameType minigameType;
    private Vec2 circlePos, circleCursorPos = Vec2.ZERO;
    private float struggleProgress = 0f;
    private Button button_fight;
    private Button button_give_up;

    /* ----------------------------- CONSTRUCTOR ----------------------------- */
    public FightToKeepConsciousnessMinigameScreen(FightToKeepConsciousnessMinigameMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.player = container.player;
        this.minigameType = container.minigameType;

        if (minigameType == MinigameType.KEY_PRESS) {
            this.imageWidth = 200;
            this.imageHeight = 166;
        } else {
            this.imageWidth = 620;
            this.imageHeight = 325;
        }
    }

    /* ----------------------------- RENDER ----------------------------- */
    @Override
    public void render(@NotNull PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);

        if(minigameType != MinigameType.MOUSE_PULL) return;

        circlePos = new Vec2((float) width / 2, (float) height / 2);
        int barWidth = 100;
        int barHeight = 10;
        int x = (int) this.getCircleCenter().x - 45;
        int y = (int) this.getCircleCenter().y + 20;
        int centerX = x + barWidth / 2;
        int filledHalfWidth = (int) (this.struggleProgress * ((float) barWidth / 2));
        fill(ms, centerX - filledHalfWidth, y, centerX + filledHalfWidth, y + barHeight, Color.WHITE.getRGB());
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        if (this.minigameType != MinigameType.KEY_PRESS) {
            int x = leftPos;
            int y = topPos;
            fill(poseStack, x, y, leftPos + imageWidth, topPos + imageHeight, Color.BLUE.getRGB());
        }

        if (minigameType == MinigameType.KEY_PRESS) {
            RenderSystem.setShaderColor(1, 1, 1, 1);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
            blit(poseStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
            RenderSystem.disableBlend();
            return;
        }

        float newX = Mth.lerp(0.25f, circleCursorPos.x, mouseX);
        float newY = Mth.lerp(0.25f, circleCursorPos.y, mouseY);
        this.circleCursorPos = clampToGuiArea(new Vec2(newX, newY), 5);

        if (circlePos != null) {
            RenderSystem.setShaderTexture(0, CIRCLE_SLOT);
            blit(poseStack, (int) circlePos.x - 9, (int) circlePos.y - 9, 0, 0, 19, 19, 19, 19);
        }
        if (circleCursorPos != null) {
            RenderSystem.setShaderTexture(0, CIRCLE_CURSOR);
            blit(poseStack, (int) circleCursorPos.x - 9, (int) circleCursorPos.y - 9, 0, 0, 19, 19, 19, 19);
        }
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        int color = minigameType != MinigameType.KEY_PRESS ? Color.WHITE.getRGB() : -12829636;

        switch (minigameType) {
            case KEY_PRESS -> {
                font.draw(poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(player)), 18, 9, color);
                font.draw(poseStack, getProgressText(player), 74, 53, color);
            }
            case MOUSE_CIRCLE_PULL -> {
                font.draw(poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(player)), getCircleCenter().x - 95, getCircleCenter().y - 50, color);
                font.draw(poseStack, getProgressText(player), circlePos.x + 10, circlePos.y + 0, color);
            }
            case MOUSE_PULL -> {
                font.draw(poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(player)), getCircleCenter().x - 95, getCircleCenter().y - 35, color);
                font.draw(poseStack, getProgressText(player), getCircleCenter().x + 10, getCircleCenter().y + 0, color);
            }
        }
    }

    /* ----------------------------- LOGIC ----------------------------- */
    @Override
    public void containerTick() {
        super.containerTick();

        if(minigameType != MinigameType.MOUSE_CIRCLE_PULL && minigameType != MinigameType.MOUSE_PULL) return;

        if(circlePos == null || circleCursorPos == null) return;

        circlePos = clampToGuiArea(circlePos, 5);
        circleCursorPos = clampToGuiArea(circleCursorPos, 5);

        if (GeometryUtil.isInsideCircle(circleCursorPos, circlePos, INTERACTION_RADIUS)) {
            increaseStruggle();
            return;
        }

        if(struggleProgress < 0){
            struggleProgress = 0;
            return;
        }

        if (minigameType == MinigameType.MOUSE_PULL && struggleProgress > 0) {
            struggleProgress = Math.max(0, struggleProgress - .05f);
        }
    }

    @Override
    public void mouseMoved(double pMouseX, double pMouseY) {
        super.mouseMoved(pMouseX, pMouseY);
        float newX = (float) Mth.lerp(0.5f, circleCursorPos.x, pMouseX);
        float newY = (float) Mth.lerp(0.5f, circleCursorPos.y, pMouseY);
        this.circleCursorPos = clampToGuiArea(new Vec2(newX, newY), 5);

        //this.updateMousePos(this.getCircleCenter());
        /*{
            if (this.minecraft != null && minigameType != MinigameType.KEY_PRESS) {
                Vec2 mouseVelocity = new Vec2(
                        (float) this.minecraft.mouseHandler.getXVelocity(),
                        (float) this.minecraft.mouseHandler.getYVelocity()
                );
                applyVelocityInCircleCursor(mouseVelocity, 0.25f);
            }
        }*/
    }

    private void applyVelocityInCircleCursor(Vec2 mouseVelocity, float speed) {
        // Aplica a velocidade
        this.circleCursorPos = this.circleCursorPos.add(mouseVelocity.scale(speed));

        // Mantém dentro da GUI
        this.circleCursorPos = clampToGuiArea(this.circleCursorPos, 5);
    }

    private void increaseStruggle() {
        if (minigameType == MinigameType.MOUSE_CIRCLE_PULL) {
            randomizePositions(60);
            ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 4));
            FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 0, 4);
            return;
        }

        struggleProgress += 0.05f;
        if (struggleProgress >= 1.0f) {
            randomizeCursorPos(450);
            ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 2));
            FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 0, 2);
        }
    }

    private void randomizePositions(float offset) {
        Random rand = player.getRandom();
        float x = getCircleCenter().x + rand.nextFloat(-offset, offset);
        float y = getCircleCenter().y + rand.nextFloat(-offset, offset);
        circlePos = clampToGuiArea(new Vec2(x, y), 10);
        randomizeCursorPos(offset / 2);
    }

    private void randomizeCursorPos(float offset) {
        Random rand = player.getRandom();
        float x = getCircleCenterOld().x + rand.nextFloat(-offset, offset);
        float y = getCircleCenterOld().y + rand.nextFloat(-offset, offset);
        this.updateMousePos(x * 1, y * 1);
        //circleCursorPos = clampToGuiArea(new Vec2(x, y), 10);
    }

    private Vec2 getCircleCenterOld() {
        return new Vec2((float) width / 2, (float) height / 2);
    }

    private Vec2 getCircleCenter() {
        float maxX = this.leftPos + this.imageWidth;
        float maxY = this.topPos + this.imageHeight;
        return new Vec2(maxX / 2, maxY / 2);
    }

    /* ----------------------------- UTILS ----------------------------- */
    private Vec2 clampToGuiArea(Vec2 pos, int padding) {
        float minX = this.leftPos + padding;
        float maxX = this.leftPos + this.imageWidth - padding;
        float minY = this.topPos + padding;
        float maxY = this.topPos + this.imageHeight + padding;
        return new Vec2(Mth.clamp(pos.x, minX, maxX), Mth.clamp(pos.y, minY, maxY));
    }

    public void updateMousePos(float screenX, float screenY) {
        setMouseVisible();
        GLFW.glfwSetCursorPos(minecraft.getWindow().getWindow(), screenX, screenY);

        if (minecraft.mouseHandler instanceof MouseHandlerAccessor mouseHandlerAccessor) {
            mouseHandlerAccessor.setXpos((int) screenX);
            mouseHandlerAccessor.setYpos((int) screenY);
        }

        setMouseInvisible();
    }

    public void updateMousePos(Vec2 screenPos) {
        setMouseVisible();
        GLFW.glfwSetCursorPos(minecraft.getWindow().getWindow(), screenPos.x, screenPos.y);
        setMouseInvisible();
    }

    public void setMouseVisible() {
        GLFW.glfwSetInputMode(minecraft.getWindow().getWindow(), GLFW.GLFW_CURSOR, InputConstants.CURSOR_NORMAL);
    }

    public void setMouseInvisible() {
        GLFW.glfwSetInputMode(minecraft.getWindow().getWindow(), GLFW.GLFW_CURSOR, InputConstants.CURSOR_DISABLED);
    }

    private void hideMouseCursor() {
        long window = minecraft.getWindow().getWindow();

        ByteBuffer buffer = MemoryUtil.memAlloc(4);
        buffer.put((byte) 255).put((byte) 255).put((byte) 255).put((byte) 1);
        buffer.flip();

        try (GLFWImage image = GLFWImage.malloc()) {
            image.set(1, 1, buffer);
            long cursor = GLFW.glfwCreateCursor(image, 0, 0);
            GLFW.glfwSetCursor(window, cursor);
        }

        MemoryUtil.memFree(buffer);
    }

    private void showDefaultMouseCursor() {
        long window = minecraft.getWindow().getWindow();
        GLFW.glfwSetCursor(window, MemoryUtil.NULL);
    }

    /* ----------------------------- EVENTS/TRIGGERS ----------------------------- */
    @Override
    public boolean keyPressed(int key, int scanCode, int modifiers) {
        if(key != InputConstants.KEY_ESCAPE) return super.keyPressed(key, scanCode, modifiers);

        player.closeContainer();
        return true;
    }

    @Override
    public void onClose() {
        super.onClose();
        Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
        setMouseVisible();
    }

    @Override
    public void removed() {
        super.removed();
        setMouseVisible();
    }

    @Override
    public void init() {
        super.init();
        minecraft.keyboardHandler.setSendRepeatsToGui(true);

        if(minigameType != MinigameType.KEY_PRESS){
            circlePos = clampToGuiArea(new Vec2(width / 2f, height / 2f), 10);
            circleCursorPos = clampToGuiArea(Vec2.ZERO, 10);
            setMouseInvisible();
            return;
        }

        if (button_fight == null) {
            button_fight = new Button(0, 0, 166, 20,
                    new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_fight"),
                    e -> {
                        ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 1));
                        FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 0, 1);
                    }
            );
        }

        if(button_give_up == null) {
            button_give_up = new Button(0, 0, 166, 20,
                    new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_give_up"),
                    e -> {
                        ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(1, 1));
                        FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(player, 1, 1);
                    }
            );
        }

        button_fight.x = leftPos + 17;
        button_fight.y = topPos + 72;

        button_give_up.x = leftPos + 17;
        button_give_up.y = topPos + 136;

        addRenderableWidget(button_fight);
        addRenderableWidget(button_give_up);
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
