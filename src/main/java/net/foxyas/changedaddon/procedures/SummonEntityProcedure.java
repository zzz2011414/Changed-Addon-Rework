package net.foxyas.changedaddon.procedures;

import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.variant.TransfurVariantInstance;
import net.ltxprogrammer.changed.process.ProcessTransfur;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;


public class SummonEntityProcedure {
    public static void execute(Level world, Player player) {
        if (world instanceof ServerLevel _level) {
            double x = player.getX();
            double y = player.getY();
            double z = player.getZ();
            TransfurVariantInstance<?> instance = ProcessTransfur.getPlayerTransfurVariant(player);
            if (instance != null) {
                ChangedEntity fakeEntity = instance.getChangedEntity();

                Entity entityToSpawn = fakeEntity.getType().create(_level);
                assert entityToSpawn != null;
                entityToSpawn.moveTo(x, y, z, 0, 0);
                entityToSpawn.setYBodyRot(0);
                entityToSpawn.setYHeadRot(0);
                if (!player.level.isClientSide() && player.getServer() != null) {
                    if (entityToSpawn instanceof Mob mob) {
                        mob.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
                    }
                    world.addFreshEntity(entityToSpawn);
                }
            }
        }

    }
}

