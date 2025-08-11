package net.foxyas.changedaddon.block.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.init.ChangedAddonBlockEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.EmptyModelData;
import org.jetbrains.annotations.NotNull;

public class LuminaraBloomBlockEntity extends BlockEntity {

    public LuminaraBloomBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ChangedAddonBlockEntities.LUMINARA_BLOOM_BLOCK_ENTITY.get(), pPos, pBlockState);
    }

    public LuminaraBloomBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public void renderExtraModel(PoseStack poseStack, float partialTick, @NotNull MultiBufferSource bufferSource, int light, int overlay) {
        BlockState state = this.getBlockState();
        poseStack.pushPose();
        Minecraft mc = Minecraft.getInstance();
        BlockRenderDispatcher blockRenderer = mc.getBlockRenderer();
        BakedModel model = blockRenderer.getBlockModel(state);
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(ChangedAddonMod.textureLoc("textures/blocks/untransfur_flower_emissive")));
        blockRenderer.getModelRenderer().renderModel(
                poseStack.last(),
                vertexConsumer,
                state,
                model,
                1,
                1,
                1,
                light,
                overlay,
                EmptyModelData.INSTANCE
        );
        poseStack.popPose();
    }
}
