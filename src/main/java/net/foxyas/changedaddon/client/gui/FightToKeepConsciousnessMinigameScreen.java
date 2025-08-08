package net.foxyas.changedaddon.client.gui;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.network.ChangedAddonModVariables;
import net.foxyas.changedaddon.network.FightToKeepConsciousnessMinigameButtonMessage;
import net.foxyas.changedaddon.util.GeometryUtil;
import net.foxyas.changedaddon.world.inventory.FightToKeepConsciousnessMinigameMenu;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.Random;

import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_NEED;
import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_TIME;

public class FightToKeepConsciousnessMinigameScreen extends AbstractContainerScreen<FightToKeepConsciousnessMinigameMenu> {

    /* ----------------------------- ENUM ----------------------------- */
    public enum MinigameType {
        MOUSE_PULL,
        MOUSE_CIRCLE_PULL,
        KEY_PRESS;

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
    private final Player entity;
    public MinigameType minigameType;
    public Vec2 circlePos, circleCursorPos = Vec2.ZERO;
    public float struggleProgress = 0f;
    Button button_fight;
    Button button_give_up;

    /* ----------------------------- CONSTRUTOR ----------------------------- */
    public FightToKeepConsciousnessMinigameScreen(FightToKeepConsciousnessMinigameMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        minecraft = Minecraft.getInstance();
        this.entity = container.entity;
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
        this.renderTooltip(ms, mouseX, mouseY);

        if (this.minigameType == MinigameType.MOUSE_PULL) {
            circlePos = new Vec2((float) width / 2, (float) height / 2);
            int barWidth = 100;
            int barHeight = 10;
            int x = (int) this.getCircleCenter().x + 10;
            int y = (int) this.getCircleCenter().y + 20;
            int centerX = x + barWidth / 2;
            int filledHalfWidth = (int) (this.struggleProgress * ((float) barWidth / 2));
            fill(ms, centerX - filledHalfWidth, y, centerX + filledHalfWidth, y + barHeight, Color.WHITE.getRGB());
        }
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

        float newX = Mth.lerp(0.5f, circleCursorPos.x, mouseX);
        float newY = Mth.lerp(0.5f, circleCursorPos.y, mouseY);
        this.circleCursorPos = clampToGuiArea(new Vec2(newX, newY), 5);

        this.button_fight.visible = false;
        this.button_give_up.visible = false;

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
        Color color = this.minigameType != MinigameType.KEY_PRESS ? Color.WHITE : new Color(-12829636);
        this.font.draw(poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(entity)), 18, 9, color.getRGB());
        this.font.draw(poseStack, getProgressText(entity), 74, 53, color.getRGB());
    }

    /* ----------------------------- LOGIC ----------------------------- */
    @Override
    public void containerTick() {
        super.containerTick();
        if (minigameType == MinigameType.MOUSE_CIRCLE_PULL || minigameType == MinigameType.MOUSE_PULL) {
            if (circlePos != null && circleCursorPos != null && minecraft != null) {
                circlePos = clampToGuiArea(circlePos, 5);
                circleCursorPos = clampToGuiArea(circleCursorPos, 5);
                if (GeometryUtil.isInsideCircle(circleCursorPos, circlePos, INTERACTION_RADIUS)) {
                    increaseStruggle();
                } else if (minigameType == MinigameType.MOUSE_PULL && struggleProgress > 0) {
                    struggleProgress -= 0.05f;
                }
            }
        }
    }

    @Override
    public void mouseMoved(double pMouseX, double pMouseY) {
        super.mouseMoved(pMouseX, pMouseY);
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
            FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 0, 4);
            return;
        }

        struggleProgress += 0.05f;
        if (struggleProgress >= 1.0f) {
            struggleProgress = 0f;
            randomizeCursorPos(120);
            ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 2));
            FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 0, 2);
        }
    }

    private void randomizePositions(float offset) {
        Random rand = entity.getRandom();
        float x = getCircleCenter().x + rand.nextFloat(-offset, offset);
        float y = getCircleCenter().y + rand.nextFloat(-offset, offset);
        circlePos = clampToGuiArea(new Vec2(x, y), 10);
        randomizeCursorPos(offset / 2);
    }

    private void randomizeCursorPos(float offset) {
        Random rand = entity.getRandom();
        float x = getCircleCenter().x + rand.nextFloat(-offset, offset);
        float y = getCircleCenter().y + rand.nextFloat(-offset, offset);
        this.updateMousePos(x * 4, y * 4);
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
        assert minecraft != null;
        GLFW.glfwSetCursorPos(minecraft.getWindow().getWindow(), screenX, screenY);
        setMouseInvisible();
    }

    public void updateMousePos(Vec2 screenPos) {
        float screenX, screenY;
        screenX = screenPos.x;
        screenY = screenPos.y;
        setMouseVisible();
        assert minecraft != null;
        GLFW.glfwSetCursorPos(minecraft.getWindow().getWindow(), screenX, screenY);
        setMouseInvisible();
    }

    public void setMouseVisible() {
        assert this.minecraft != null;
        GLFW.glfwSetInputMode(this.minecraft.getWindow().getWindow(), 208897, InputConstants.CURSOR_NORMAL);
    }

    public void setMouseInvisible() {
        assert this.minecraft != null;
        GLFW.glfwSetInputMode(this.minecraft.getWindow().getWindow(), 208897, InputConstants.CURSOR_DISABLED);
    }

    private void hideMouseCursor() {
        assert this.minecraft != null;
        long window = this.minecraft.getWindow().getWindow();

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
        assert this.minecraft != null;
        long window = this.minecraft.getWindow().getWindow();
        GLFW.glfwSetCursor(window, MemoryUtil.NULL);
    }

    /* ----------------------------- EVENTS/TRIGGERS ----------------------------- */
    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == InputConstants.KEY_ESCAPE) {
            if (minecraft != null && minecraft.player != null) {
                minecraft.player.closeContainer();
            }
            return true;
        }
        return super.keyPressed(key, b, c);
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
        assert minecraft != null;
        minecraft.keyboardHandler.setSendRepeatsToGui(true);

        button_fight = new Button(this.leftPos + 17, this.topPos + 72, 166, 20,
                new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_fight"),
                e -> {
                    ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, 1));
                    FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 0, 1);
                });

        button_give_up = new Button(this.leftPos + 17, this.topPos + 136, 166, 20,
                new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.button_give_up"),
                e -> {
                    ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(1, 1));
                    FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 1, 1);
                });

        if (minigameType == MinigameType.KEY_PRESS) {
            this.button_fight.visible = true;
            this.button_give_up.visible = true;
            this.addRenderableWidget(button_fight);
            this.addRenderableWidget(button_give_up);
        } else {
            this.button_fight.visible = false;
            this.button_give_up.visible = false;
            circlePos = clampToGuiArea(new Vec2(width / 2f, height / 2f), 10);
            circleCursorPos = clampToGuiArea(Vec2.ZERO, 10);
            setMouseInvisible();
        }
    }

    /* ----------------------------- STATIC METHODS ----------------------------- */
    public static String getProgressText(Entity entity) {
        if (entity == null) return "";
        return entity.getCapability(ChangedAddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new ChangedAddonModVariables.PlayerVariables())
                .consciousnessFightProgress + "/" + STRUGGLE_NEED;
    }

    public static String getTimeRemaining(Entity entity) {
        if (entity instanceof Player player) {
            TransfurVariantInstance<?> TransfurInstance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (TransfurInstance != null) {
                int ticks = TransfurInstance.ageAsVariant / STRUGGLE_TIME;
                return "" + ticks;
            }
        }
        return "";
    }
}
