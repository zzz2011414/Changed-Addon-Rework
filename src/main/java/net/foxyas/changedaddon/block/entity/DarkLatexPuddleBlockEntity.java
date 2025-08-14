package net.foxyas.changedaddon.block.entity;

import net.foxyas.changedaddon.init.ChangedAddonBlockEntities;
import net.ltxprogrammer.changed.block.NonLatexCoverableBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DarkLatexPuddleBlockEntity extends BlockEntity implements NonLatexCoverableBlock {

    public DarkLatexPuddleBlockEntity(BlockPos position, BlockState state) {
        super(ChangedAddonBlockEntities.DARK_LATEX_PUDDLE.get(), position, state);
    }
}
