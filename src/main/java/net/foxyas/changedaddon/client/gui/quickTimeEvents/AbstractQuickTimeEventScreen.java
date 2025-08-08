package net.foxyas.changedaddon.client.gui.quickTimeEvents;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.gui.FightToKeepConsciousnessMinigameScreen;
import net.foxyas.changedaddon.mixins.client.MouseHandlerAccessor;
import net.foxyas.changedaddon.network.FightToKeepConsciousnessMinigameButtonMessage;
import net.foxyas.changedaddon.util.GeometryUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.system.MemoryUtil;

import java.awt.*;
import java.nio.ByteBuffer;
import java.util.Random;

public abstract class AbstractQuickTimeEventScreen<M extends AbstractContainerMenu> extends AbstractContainerScreen<M> {

    private final Player player;
    public Vec2 circlePos = Vec2.ZERO;
    public Vec2 circleCursorPos = Vec2.ZERO;
    public float struggleProgress = 0f;

    public AbstractQuickTimeEventScreen(M pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        minecraft = Minecraft.getInstance();
        this.player = pPlayerInventory.player;
    }

    @Override
    public void render(@NotNull PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);

        circlePos = new Vec2((float) width / 2, (float) height / 2);
        int barWidth = 100;
        int barHeight = 10;
        int x = (int) this.getCircleCenter().x - 45;
        int y = (int) this.getCircleCenter().y + 20;
        int centerX = x + barWidth / 2;
        int filledHalfWidth = (int) (this.struggleProgress * ((float) barWidth / 2));
        fill(ms, centerX - filledHalfWidth, y, centerX + filledHalfWidth, y + barHeight, Color.WHITE.getRGB());
    }

    public abstract ResourceLocation getCircleSlot();

    public abstract ResourceLocation getCircleCursor();

    protected abstract float getInteractionRadios();


    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        float newX = Mth.lerp(0.25f, circleCursorPos.x, mouseX);
        float newY = Mth.lerp(0.25f, circleCursorPos.y, mouseY);
        this.circleCursorPos = clampToGuiArea(new Vec2(newX, newY), 5);

        if (circlePos != null) {
            RenderSystem.setShaderTexture(0, getCircleSlot());
            blit(poseStack, (int) circlePos.x - 9, (int) circlePos.y - 9, 0, 0, 19, 19, 19, 19);
        }
        if (circleCursorPos != null) {
            RenderSystem.setShaderTexture(0, getCircleCursor());
            blit(poseStack, (int) circleCursorPos.x - 9, (int) circleCursorPos.y - 9, 0, 0, 19, 19, 19, 19);
        }
    }

    /* ----------------------------- LOGIC ----------------------------- */
    @Override
    public void containerTick() {
        super.containerTick();
        if (circlePos != null && circleCursorPos != null && minecraft != null) {
            circlePos = clampToGuiArea(circlePos, 5);
            circleCursorPos = clampToGuiArea(circleCursorPos, 5);
            if (GeometryUtil.isInsideCircle(circleCursorPos, circlePos, getInteractionRadios())) {
                increaseStruggle();
            } else if (struggleProgress > 0) {
                if (struggleProgress - 0.05 >= 0) {
                    struggleProgress -= 0.05f;
                } else {
                    struggleProgress = 0;
                }
            } else if (struggleProgress < 0) {
                struggleProgress = 0;
            }
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

    protected abstract void increaseStruggle();

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
        if (minecraft.mouseHandler instanceof MouseHandlerAccessor mouseHandlerAccessor) {
            mouseHandlerAccessor.setXpos((int) screenX);
            mouseHandlerAccessor.setYpos((int) screenY);
        }
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
        circlePos = clampToGuiArea(new Vec2(width / 2f, height / 2f), 10);
        circleCursorPos = clampToGuiArea(Vec2.ZERO, 10);
        setMouseInvisible();
    }

}
