package net.foxyas.changedaddon.client.renderer.blockEntitys;

import com.mojang.blaze3d.vertex.PoseStack;
import net.foxyas.changedaddon.block.entity.LuminaraBloomBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class LuminaraBloomBlockEntityRenderer implements BlockEntityRenderer<LuminaraBloomBlockEntity> {

    public LuminaraBloomBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super();
    }

    @Override
    public void render(@NotNull LuminaraBloomBlockEntity luminaraBloomBlockEntity, float partialTick, @NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int light, int overlay) {
        luminaraBloomBlockEntity.renderExtraModel(poseStack,partialTick, bufferSource, light, overlay);
    }

    @Override
    public boolean shouldRenderOffScreen(@NotNull LuminaraBloomBlockEntity pBlockEntity) {
        return BlockEntityRenderer.super.shouldRenderOffScreen(pBlockEntity);
    }

    @Override
    public int getViewDistance() {
        return 1024;
    }

    @Override
    public boolean shouldRender(@NotNull LuminaraBloomBlockEntity pBlockEntity, @NotNull Vec3 pCameraPos) {
        return BlockEntityRenderer.super.shouldRender(pBlockEntity, pCameraPos);
    }
}
