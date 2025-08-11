package net.foxyas.changedaddon.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxyas.changedaddon.client.model.LuminarcticLeopardModel;
import net.foxyas.changedaddon.client.renderer.layers.LuminarcticLeopardsConditionalLayers;
import net.foxyas.changedaddon.entity.bosses.LuminarcticLeopardFemaleEntity;
import net.foxyas.changedaddon.entity.bosses.LuminarcticLeopardMaleEntity;
import net.foxyas.changedaddon.entity.defaults.AbstractLuminarcticLeopard;
import net.ltxprogrammer.changed.ability.HypnosisAbility;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.AdvancedHumanoidModel;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleCatModel;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class LuminarcticLeopardMaleRenderer extends AdvancedHumanoidRenderer<LuminarcticLeopardMaleEntity, LuminarcticLeopardModel, ArmorLatexMaleCatModel<LuminarcticLeopardMaleEntity>> {
    public LuminarcticLeopardMaleRenderer(EntityRendererProvider.Context context) {
        super(context, new LuminarcticLeopardModel(context.bakeLayer(LuminarcticLeopardModel.LAYER_LOCATION)),
                ArmorLatexMaleCatModel.MODEL_SET, 0.5f);

        this.addLayer(new LatexParticlesLayer<>(this, getModel(), model::isPartNotArmFur));

        Color3 RED = new Color3(255, 0, 0);
        this.addLayer(new LuminarcticLeopardsConditionalLayers.CustomEyesLayer<>(this,
                new CustomEyesLayer<>(this, context.getModelSet(),
                        CustomEyesLayer::scleraColor,
                        CustomEyesLayer::irisColorLeft,
                        CustomEyesLayer::irisColorRight,
                        CustomEyesLayer::noRender,
                        CustomEyesLayer::noRender)
                ,
                new CustomEyesLayer<>(this, context.getModelSet(),
                        CustomEyesLayer::scleraColor,
                        CustomEyesLayer::glowingIrisColorLeft,
                        CustomEyesLayer::glowingIrisColorRight,
                        CustomEyesLayer::noRender,
                        CustomEyesLayer::noRender)
        ));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
        this.addLayer(new LuminarcticLeopardsConditionalLayers.GlowLayer<>(this, new ResourceLocation("changed_addon:textures/entities/luminarctic_leopards/male/luminarctic_leopard_ability_active.png")));
        this.addLayer(new LuminarcticLeopardsConditionalLayers.GlowFelineEyesLayer<>(this, new ResourceLocation("changed_addon:textures/entities/luminarctic_leopards/male/luminarctic_leopard_feline_eyes_male.png")));
        this.addLayer(new EmissiveBodyLayer<>(this, new ResourceLocation("changed_addon:textures/entities/luminarctic_leopards/crystals_layer.png")));
    }

    @Override
    public void render(LuminarcticLeopardMaleEntity entity, float yRot, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        /*float dodgeTicks = entity.getDodgeAnimTicks();
        float dodgeProgress = Math.abs(dodgeTicks) / (float) entity.DodgeAnimMaxTicks;

        this.model.dodgeProgress = dodgeProgress;
        this.model.partialTicks = partialTicks;
        this.model.isReverse = dodgeTicks < 0;

        // Passa o progresso e direção para o modelo
        if (dodgeProgress > 0) {
            poseStack.pushPose();
            float rotationAngle = (entity.getDodgeType() == 1 ? 65.0F : 45.0f) * dodgeProgress; // Rotaciona até 90° conforme o progresso da animação
            // Aplica a rotação no eixo X
            if (dodgeTicks > 0) {
                poseStack.mulPose(Vector3f.YP.rotationDegrees(rotationAngle));
            } else {
                poseStack.mulPose(Vector3f.YN.rotationDegrees(rotationAngle));
            }
            // Renderiza o modelo normalmente (chama o super ou código adicional aqui)
            super.render(entity, yRot, partialTicks, poseStack, bufferSource, packedLight);
            poseStack.popPose(); // Restaura a pose original
        } else {
            super.render(entity, yRot, partialTicks, poseStack, bufferSource, packedLight);
        }*/
        super.render(entity, yRot, partialTicks, poseStack, bufferSource, packedLight);

    }


    @Override
    public ResourceLocation getTextureLocation(LuminarcticLeopardMaleEntity entity) {
        if (entity.getUnderlyingPlayer() != null) {
            return new ResourceLocation("changed_addon:textures/entities/luminarctic_leopards/male/luminarctic_leopard_no_eyes.png");
        }

        return new ResourceLocation("changed_addon:textures/entities/luminarctic_leopards/male/luminarctic_leopard.png");
    }
}
