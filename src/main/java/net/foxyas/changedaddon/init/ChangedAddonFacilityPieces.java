package net.foxyas.changedaddon.init;

import net.ltxprogrammer.changed.world.features.structures.LootTables;
import net.ltxprogrammer.changed.world.features.structures.facility.FacilityPieceCollectionBuilder;
import net.ltxprogrammer.changed.world.features.structures.facility.FacilityRoomPiece;
import net.ltxprogrammer.changed.world.features.structures.facility.GatherFacilityPiecesEvent;
import net.minecraft.resources.ResourceLocation;

public class ChangedAddonFacilityPieces {

    public static void RegisterAddonFacilityPieces(GatherFacilityPiecesEvent event) {
        event.register(FacilityPieceCollectionBuilder.WEIGHT_COMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_hallways/specimen_containment_a"), LootTables.HIGH_TIER_LAB));
        event.register(FacilityPieceCollectionBuilder.WEIGHT_COMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_hallways/specimen_containment_b"), LootTables.HIGH_TIER_LAB));

        event.register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/exp009room"), new ResourceLocation("changed_addon:chests/experiment_009_loot_dna")));
        event.register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/exp10room"), new ResourceLocation("changed_addon:chests/experiment_10_loot_op")));
        event.register(FacilityPieceCollectionBuilder.WEIGHT_UNCOMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/luminar_crystal_room"), new ResourceLocation("changed:chests/high_tier_lab")));
        event.register(FacilityPieceCollectionBuilder.WEIGHT_COMMON, new FacilityRoomPiece(new ResourceLocation("changed_addon:facility_rooms/closed_meteor"), new ResourceLocation("changed:chests/high_tier_lab")));
    }
}