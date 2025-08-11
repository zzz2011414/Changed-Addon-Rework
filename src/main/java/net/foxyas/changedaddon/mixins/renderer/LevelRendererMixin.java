package net.foxyas.changedaddon.mixins.renderer;

import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.entity.bosses.LuminarcticLeopardMaleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.io.IOException;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {

    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    @Nullable
    public abstract RenderTarget entityTarget();

    @Shadow
    @Nullable
    private RenderTarget entityTarget;
    @Unique
    private PostChain changed_Addon_Rework$lightBloomEffectChain;

    @Unique
    private int changed_Addon_Rework$prevWidth = -1;

    @Unique
    private int changed_Addon_Rework$prevHeight = -1;


    @Inject(method = "renderEntity", at = @At("TAIL"), cancellable = true)
    private void InjectBloomEffect(Entity pEntity, double pCamX, double pCamY, double pCamZ, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, CallbackInfo ci) {
        if (this.entityTarget != null && pEntity instanceof LuminarcticLeopardMaleEntity luminarcticLeopardMaleEntity && luminarcticLeopardMaleEntity.isActivatedAbility()) {
            if (this.changed_Addon_Rework$lightBloomEffectChain == null) {
                changed_Addon_Rework$loadLightBloomShader();
            } else {
                int w = entityTarget.width;
                int h = entityTarget.height;
                if (w != changed_Addon_Rework$prevWidth || h != changed_Addon_Rework$prevHeight) {
                    this.changed_Addon_Rework$lightBloomEffectChain.resize(w, h);
                    changed_Addon_Rework$prevWidth = w;
                    changed_Addon_Rework$prevHeight = h;
                }

                this.changed_Addon_Rework$lightBloomEffectChain.process(minecraft.getFrameTime());
            }
        }
    }

    @Unique
    private void changed_Addon_Rework$loadLightBloomShader() {
        try {
            if (this.entityTarget != null) {
                this.changed_Addon_Rework$lightBloomEffectChain = new PostChain(
                        this.minecraft.getTextureManager(),
                        this.minecraft.getResourceManager(),
                        this.entityTarget,
                        new ResourceLocation(ChangedAddonMod.MODID, "shaders/post/light_bloom.json")
                );
                this.changed_Addon_Rework$lightBloomEffectChain.resize(this.minecraft.getWindow().getWidth(), this.minecraft.getWindow().getHeight());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
