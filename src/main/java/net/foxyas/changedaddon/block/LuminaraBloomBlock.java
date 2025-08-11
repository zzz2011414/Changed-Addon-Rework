package net.foxyas.changedaddon.block;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.init.ChangedAddonBlocks;
import net.foxyas.changedaddon.init.ChangedAddonMobEffects;
import net.foxyas.changedaddon.util.FoxyasUtils;
import net.foxyas.changedaddon.util.GeometryUtil;
import net.ltxprogrammer.changed.block.AbstractLatexBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.client.model.data.EmptyModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class LuminaraBloomBlock extends FlowerBlock implements BonemealableBlock {
    public LuminaraBloomBlock() {
        super(ChangedAddonMobEffects.UNTRANSFUR, 60,
                BlockBehaviour.Properties.of(Material.PLANT)
                        .emissiveRendering((state, blockGetter, blockPos) -> true)
                        .hasPostProcess((state, blockGetter, blockPos) -> true)
                        .noCollission().dynamicShape().instabreak().sound(SoundType.GRASS));
    }

    @Override
    public @NotNull MobEffect getSuspiciousStewEffect() {
        return super.getSuspiciousStewEffect();
    }

    public static void registerRenderLayer() {
        ItemBlockRenderTypes.setRenderLayer(ChangedAddonBlocks.LUMINARA_BLOOM.get(), renderType -> renderType == RenderType.cutout());
    }

    @SuppressWarnings("deprecation")
    @Override
    public int getLightBlock(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return 3;
    }

    @Override
    public boolean canSurvive(@NotNull BlockState pState, @NotNull LevelReader pLevel, @NotNull BlockPos pPos) {
        BlockState below = pLevel.getBlockState(pPos.below());
        if (below.getBlock() instanceof AbstractLatexBlock) {
            return true;
        }
        return super.canSurvive(pState, pLevel, pPos);
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        if (pState.getBlock() instanceof AbstractLatexBlock) {
            return true;
        }
        return super.mayPlaceOn(pState, pLevel, pPos);
    }

//    @Override
//    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean pIsClient) {
//        BlockState below = blockGetter.getBlockState(blockPos.below());
//        return below.getBlock() instanceof AbstractLatexBlock || below.is(BlockTags.DIRT) || below.is(Blocks.FARMLAND);
//    }

    @Override
    public boolean isValidBonemealTarget(@NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, boolean pIsClient) {
        return BlockPos.betweenClosedStream(new AABB(blockPos).inflate(3, 1, 3))
                .anyMatch(pos -> {
                    BlockState normal = blockGetter.getBlockState(pos);
                    BlockState below = blockGetter.getBlockState(pos.below());
                    return normal.isAir() && (below.getBlock() instanceof AbstractLatexBlock || below.is(BlockTags.DIRT) || below.is(Blocks.FARMLAND));
                });
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level level, @NotNull Random random, @NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel serverLevel, @NotNull Random random, @NotNull BlockPos pos, @NotNull BlockState state) {

        //Vanilla like behavior
        int tries = 16;
        for (int i = 0; i < tries; i++) {
            BlockPos targetPos = pos.offset(
                    random.nextInt(7) - 3, // X: -2 to +2
                    random.nextInt(3) - 1, // Y: -1 to +1
                    random.nextInt(7) - 3  // Z: -2 to +2
            );
            if (serverLevel.isEmptyBlock(targetPos)) {
                BlockState below = serverLevel.getBlockState(targetPos.below());
                if (below.getBlock() instanceof AbstractLatexBlock || below.is(BlockTags.DIRT) || below.is(Blocks.FARMLAND)) {
                    serverLevel.setBlock(targetPos, state, 3);
                }
            }
        }

        /*
        * less vanilla like behavior
        List<BlockPos> list = FoxyasUtils.betweenClosedStreamSphere(pos, 3,1, 1f).toList();
        for (BlockPos blockPos : list) {
            if (serverLevel.getRandom().nextFloat() >= 0.5f && serverLevel.isEmptyBlock(blockPos)) {
                BlockState below = serverLevel.getBlockState(blockPos.below());
                if (below.getBlock() instanceof AbstractLatexBlock || below.is(BlockTags.DIRT) || below.is(Blocks.FARMLAND)) {
                    serverLevel.setBlock(blockPos, state, 3);
                }
            }
        }*/
    }

}
