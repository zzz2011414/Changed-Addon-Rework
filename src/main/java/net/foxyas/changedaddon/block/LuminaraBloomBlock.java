package net.foxyas.changedaddon.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.block.entity.LuminaraBloomBlockEntity;
import net.foxyas.changedaddon.init.ChangedAddonBlocks;
import net.foxyas.changedaddon.init.ChangedAddonMobEffects;
import net.ltxprogrammer.changed.block.AbstractLatexBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.client.model.data.EmptyModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LuminaraBloomBlock extends FlowerBlock implements EntityBlock {
    public LuminaraBloomBlock() {
        super(ChangedAddonMobEffects.UNTRANSFUR, 60,
                BlockBehaviour.Properties.of(Material.PLANT).noCollission().dynamicShape().instabreak().sound(SoundType.GRASS));
    }

    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(ChangedAddonBlocks.LUMINARA_BLOOM.get(), renderType -> renderType == RenderType.cutout());
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, @NotNull LevelReader pLevel, @NotNull BlockPos pPos) {
        return super.canSurvive(pState, pLevel, pPos);
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        if (pState.getBlock() instanceof AbstractLatexBlock) {
            return true;
        }
        return super.mayPlaceOn(pState, pLevel, pPos);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LuminaraBloomBlockEntity(blockPos, blockState);
    }
}
