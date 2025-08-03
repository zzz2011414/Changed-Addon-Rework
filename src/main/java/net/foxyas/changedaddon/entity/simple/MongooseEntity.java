package net.foxyas.changedaddon.entity.simple;

import net.foxyas.changedaddon.client.model.animations.parameters.PatReactionAnimationParameters;
import net.foxyas.changedaddon.entity.interfaces.CustomPatReaction;
import net.foxyas.changedaddon.entity.defaults.AbstractBasicChangedEntity;
import net.foxyas.changedaddon.init.ChangedAddonAnimationEvents;
import net.foxyas.changedaddon.init.ChangedAddonEntities;
import net.ltxprogrammer.changed.entity.AttributePresets;
import net.ltxprogrammer.changed.entity.ChangedEntity;
import net.ltxprogrammer.changed.entity.TransfurCause;
import net.ltxprogrammer.changed.entity.TransfurMode;
import net.ltxprogrammer.changed.init.ChangedAnimationEvents;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

public class MongooseEntity extends AbstractBasicChangedEntity implements CustomPatReaction {
    public MongooseEntity(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public MongooseEntity(PlayMessages.SpawnEntity ignoredPacket, Level world) {
        this(ChangedAddonEntities.MONGOOSE.get(), world);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        AttributePresets.wolfLike(attributes);
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return this.random.nextBoolean() ? Color3.parseHex("#d59871") : Color3.parseHex("#5c5c5c");
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.REPLICATION;
    }

    public Color3 getDripColor() {
        return this.random.nextBoolean() ? Color3.parseHex("#d59871") : Color3.parseHex("#5c5c5c");
    }

    @Override
    public void WhenPattedReaction(Player patter, Vec3 pattedLocation) {
        ChangedAnimationEvents.broadcastEntityAnimation(this, ChangedAddonAnimationEvents.PAT_REACTION.get(), PatReactionAnimationParameters.INSTANCE);
    }
}
