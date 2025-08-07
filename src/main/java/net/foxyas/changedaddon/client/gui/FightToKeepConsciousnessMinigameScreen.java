
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
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;

import java.awt.*;
import java.util.HashMap;
import java.util.Random;

import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_NEED;
import static net.foxyas.changedaddon.procedures.FightToKeepYourConsciousnessHandle.STRUGGLE_TIME;

public class FightToKeepConsciousnessMinigameScreen extends AbstractContainerScreen<FightToKeepConsciousnessMinigameMenu> {

    public enum MinigameType {
        MOUSE_PULL,
        MOUSE_CIRCLE_PULL,
        KEY_PRESS;

        MinigameType() {
        }

        @Override
        public String toString() {
            return super.toString();
        }

        public static MinigameType getRandom(Random random) {
            return values()[random.nextInt(values().length)];
        }
    }

    private final static HashMap<String, Object> guistate = FightToKeepConsciousnessMinigameMenu.guistate;
    private final Level world;
    private final int x, y, z;
    private final Player entity;
    public MinigameType minigameType;
    public Vec2 circlePos, circleCursorPos = Vec2.ZERO;
    Button button_fight;
    Button button_give_up;

    public FightToKeepConsciousnessMinigameScreen(FightToKeepConsciousnessMinigameMenu container, Inventory inventory, Component text) {
        super(container, inventory, text);
        this.world = container.world;
        this.x = container.x;
        this.y = container.y;
        this.z = container.z;
        this.entity = container.entity;
        this.imageWidth = 200;
        this.imageHeight = 166;
        this.minigameType = container.minigameType;
    }

    private static final ResourceLocation BACKGROUND_TEXTURE = ChangedAddonMod.textureLoc("textures/screens/qtes/fight_to_keep_consciousness/fight_to_keep_consciousness_minigame");
    public static final ResourceLocation CIRCLE_SLOT = ChangedAddonMod.textureLoc("textures/screens/qtes/fight_to_keep_consciousness/struggle_circle_slot");
    public static final ResourceLocation CIRCLE_CURSOR = ChangedAddonMod.textureLoc("textures/screens/qtes/fight_to_keep_consciousness/struggle_circle_cursor");

    @Override
    public void render(@NotNull PoseStack ms, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(ms);
        super.render(ms, mouseX, mouseY, partialTicks);
        this.renderTooltip(ms, mouseX, mouseY);
    }

    @Override
    protected void renderBg(@NotNull PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        // Atualiza a posição atual do cursor do jogador
        //Vec2 relative = new Vec2(mouseX - circleCursorPos.x, mouseY - circleCursorPos.y);
        //this.circleCursorPos = this.circleCursorPos.add(relative.scale(0.25f));
//        this.circleCursorPos = new Vec2(
//                Mth.lerp(0.25f, circleCursorPos.x, mouseX),
//                Mth.lerp(0.25f, circleCursorPos.y, mouseY)
//        );
        if (minecraft != null) {
            float newX = Mth.lerp(1, circleCursorPos.x, mouseX);
            float newY = Mth.lerp(1, circleCursorPos.y, mouseY);

            int screenWidth = minecraft.getWindow().getScreenWidth();
            int screenHeight = minecraft.getWindow().getScreenHeight();

            // Limita a posição dentro da janela
            float clampedX = Mth.clamp(newX, 0, screenWidth - 2);
            float clampedY = Mth.clamp(newY, 0, screenHeight - 2);

            this.circleCursorPos = new Vec2(clampedX, clampedY);
        }


        if (minigameType == MinigameType.KEY_PRESS) {
            // Renderiza fundo normal
            RenderSystem.setShaderColor(1, 1, 1, 1);
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShaderTexture(0, BACKGROUND_TEXTURE);
            blit(poseStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
            RenderSystem.disableBlend();
        } else {
            // Oculta botões (uma vez)
            this.button_fight.visible = false;
            this.button_give_up.visible = false;

            // Renderiza um "slot" (representa o alvo)
            RenderSystem.setShaderTexture(0, CIRCLE_SLOT); // ou outro ícone
            blit(poseStack, (int) circlePos.x - 9, (int) circlePos.y - 9, 0, 0, 19, 19, 19, 19);
            RenderSystem.setShaderTexture(0, CIRCLE_CURSOR); // ou outro ícone
            blit(poseStack, (int) circleCursorPos.x - 9, (int) circleCursorPos.y - 9, 0, 0, 19, 19, 19, 19);
        }
    }

    private float struggleProgress = 0f;
    private static final float INTERACTION_RADIUS = 15f;

    private void increaseStruggle() {
        ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, x, y, z));
        FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 0, x, y, z);
    }

    private void randomizePositions() {
        // Usado em MOUSE_CIRCLE_PULL
        Random rand = new Random();
        float offset = 60f;
        float x = circlePos.x + rand.nextFloat(-offset, offset);
        float y = circlePos.y + rand.nextFloat(-offset, offset);
        float clampedX = Mth.clamp(x, 40, this.width - 40);
        float clampedY = Mth.clamp(y, 40, this.height - 40);
        this.circlePos = new Vec2(clampedX, clampedY);

        randomizeCursorPos();
    }

    private void randomizeCirclePosition() {
        // Usado em MOUSE_CIRCLE_PULL
        Random rand = new Random();
        float x = leftPos + 20 + rand.nextInt(width - 40);
        float y = topPos + 20 + rand.nextInt(height - 40);
        float clampedX = Mth.clamp(x, 0, this.width - 2);
        float clampedY = Mth.clamp(y, 0, this.height - 2);
        this.circlePos = new Vec2(x, y);
    }

    private void randomizeCursorPos() {
        Random rand = new Random();
        float offset = 60f;
        float x = circleCursorPos.x + rand.nextFloat(-offset, offset);
        float y = circleCursorPos.y + rand.nextFloat(-offset, offset);
        float clampedX = Mth.clamp(x, 40, this.width - 40);
        float clampedY = Mth.clamp(y, 40, this.height - 40);
        this.circleCursorPos = new Vec2(clampedX, clampedY);
        if (minecraft != null) {
            GLFW.glfwSetCursorPos(minecraft.getWindow().getWindow(), (double) width / 2 + circleCursorPos.x,
                    (double) height / 2 + circleCursorPos.y);
            updateMousePos((int) ((double) width / 2 + circleCursorPos.x),
                    (int) ((double) height / 2 + circleCursorPos.y));
        }
//        if (this.minecraft != null && minecraft.mouseHandler instanceof MouseHandlerAccessor mouseHandlerAccessor) {
//            mouseHandlerAccessor.setXpos(circleCursorPos.x);
//            mouseHandlerAccessor.setYpos(circleCursorPos.y);
//            //this.setRealMousePosition((int) circleCursorPos.x, (int) circleCursorPos.y);
//        }
    }

    public void updateMousePos(int screenX, int screenY) {
        if (this.minecraft != null) {
            this.minecraft.mouseHandler.setIgnoreFirstMove();
        }
        try {
            Robot robot = new Robot();
            robot.mouseMove(screenX, screenY);
        } catch (AWTException ignored) {
        }
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean keyPressed(int key, int b, int c) {
        if (key == 256) {
            assert this.minecraft != null;
            assert this.minecraft.player != null;
            this.minecraft.player.closeContainer();
            return true;
        }
        return super.keyPressed(key, b, c);
    }

    @Override
    public void containerTick() {
        super.containerTick();
        if (minigameType == MinigameType.MOUSE_CIRCLE_PULL || minigameType == MinigameType.MOUSE_PULL) {
            if (circlePos != null && circleCursorPos != null) {
                if (GeometryUtil.isInsideCircle(circleCursorPos, circlePos, INTERACTION_RADIUS)) {
                    if (minigameType == MinigameType.MOUSE_CIRCLE_PULL) {
                        increaseStruggle();
                        randomizePositions();
                    } else {
                        circlePos = new Vec2((float) width / 2, (float) height / 2);
                        struggleProgress += 0.05f;
                        if (struggleProgress >= 1.0f) {
                            increaseStruggle();
                            struggleProgress = 0f;
                            randomizeCursorPos();
                        }
                    }
                } else if (minigameType == MinigameType.MOUSE_PULL) {
                    if (struggleProgress > 0) {
                        increaseStruggle();
                        struggleProgress -= 0.05f;
                        randomizeCursorPos();
                    }
                }
            }
        }
    }

    @Override
    protected void renderLabels(@NotNull PoseStack poseStack, int mouseX, int mouseY) {
        Color color = new Color(-12829636);
        if (this.minigameType != MinigameType.KEY_PRESS) {
            color = new Color(255, 255, 255);
        }
        this.font.draw(poseStack, new TranslatableComponent("gui.changed_addon.fight_to_keep_consciousness_minigame.label_text", getTimeRemaining(entity)), 18, 9, color.getRGB());
        this.font.draw(poseStack, getProgressText(entity), 74, 53, color.getRGB());
    }

    public static String getProgressText(Entity entity) {
        if (entity == null)
            return "";
        return entity.getCapability(ChangedAddonModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new ChangedAddonModVariables.PlayerVariables())
                .consciousness_fight_progress + "/" + STRUGGLE_NEED;
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
        assert this.minecraft != null;
        this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
        if (this.minecraft.player != null) {
            this.minecraft.player.displayClientMessage(new TextComponent(this.minigameType.toString()), false);
        }
        button_fight = new Button(this.leftPos + 17, this.topPos + 72, 166, 20, new TranslatableComponent("gui.changed_addon.fight_tokeepconsciousnessminigame.button_fight"), e -> {
            {
                ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(0, x, y, z));
                FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 0, x, y, z);
            }
        });
        guistate.put("button:button_fight", button_fight);
        this.addRenderableWidget(button_fight);
        button_give_up = new Button(this.leftPos + 17, this.topPos + 136, 166, 20, new TranslatableComponent("gui.changed_addon.fight_tokeepconsciousnessminigame.button_give_up"), e -> {
            {
                ChangedAddonMod.PACKET_HANDLER.sendToServer(new FightToKeepConsciousnessMinigameButtonMessage(1, x, y, z));
                FightToKeepConsciousnessMinigameButtonMessage.handleButtonAction(entity, 1, x, y, z);
            }
        });
        guistate.put("button:button_give_up", button_give_up);
        if (minigameType == MinigameType.KEY_PRESS) {
            this.button_fight.visible = true;
            this.button_give_up.visible = true;
            this.addRenderableWidget(button_give_up);
        } else {
            this.button_fight.visible = false;
            this.button_give_up.visible = false;
            if (minigameType == MinigameType.MOUSE_CIRCLE_PULL) {
                randomizePositions();
            } else if (minigameType == MinigameType.MOUSE_PULL) {
                circlePos = new Vec2((float) width / 2, (float) height / 2);
            }
            setMouseInvisible();
            //var xpos = (double)(this.minecraft.getWindow().getScreenWidth() / 2);
            //var ypos = (double)(this.minecraft.getWindow().getScreenHeight() / 2);
            //InputConstants.grabOrReleaseMouse(this.minecraft.getWindow().getWindow(), 212995, xpos, ypos);
        }
    }

    public void setMouseVisible() {
        if (this.minecraft != null) {
            GLFW.glfwSetInputMode(this.minecraft.getWindow().getWindow(), 208897, InputConstants.CURSOR_NORMAL);
        }
    }

    public void setMouseInvisible() {
        if (this.minecraft != null) {
            GLFW.glfwSetInputMode(this.minecraft.getWindow().getWindow(), 208897, InputConstants.CURSOR_DISABLED);
        }
    }
}
