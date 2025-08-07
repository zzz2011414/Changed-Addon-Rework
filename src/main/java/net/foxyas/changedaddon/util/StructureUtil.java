package net.foxyas.changedaddon.util;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureStart;

public class StructureUtil {

    public static StructureStart getStructureAt(ServerLevel level, BlockPos pos, ResourceLocation structureId){
        ConfiguredStructureFeature<?, ?> structure = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE.get(structureId);

        return structure == null ? null : level.structureFeatureManager().getStructureAt(pos, structure);
    }

    /**
     * Verifica se uma estrutura pode gerar dentro de um determinado raio de chunks.
     *
     * @param level     o ServerLevel
     * @param pos       a posição a ser verificada
     * @param structure ResourceKey da estrutura
     * @param chunkRange o raio de chunks a ser verificado
     * @return true se a estrutura pode gerar na área, false caso contrário.
     */
    public static boolean isStructureNearby(ServerLevel level, BlockPos pos, ResourceKey<StructureSet> structure, int chunkRange) {
        return level.getChunkSource().getGenerator().hasFeatureChunkInRange(structure, level.getSeed(), SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()), chunkRange);
    }

    /**
     * Verifica se uma estrutura pode gerar dentro de um determinado raio de chunks.
     *
     * @param level       o ServerLevel
     * @param pos         a posição a ser verificada
     * @param structureId o ID da estrutura desejada (ex.: "changed_addon:dazed_meteor")
     * @param chunkRange  o raio de chunks a ser verificado
     * @return true se a estrutura pode gerar na área, false caso contrário.
     */
    public static boolean isStructureNearby(ServerLevel level, BlockPos pos, String structureId, int chunkRange) {
        ResourceKey<StructureSet> structureKey = ResourceKey.create(BuiltinRegistries.STRUCTURE_SETS.key(), new ResourceLocation(structureId));
        return isStructureNearby(level, pos, structureKey, chunkRange);
    }
}
