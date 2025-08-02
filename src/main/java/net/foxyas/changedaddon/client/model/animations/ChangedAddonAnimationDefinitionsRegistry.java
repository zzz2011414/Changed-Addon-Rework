package net.foxyas.changedaddon.client.model.animations;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.ltxprogrammer.changed.client.animations.AnimationDefinitions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = {Dist.CLIENT}, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChangedAddonAnimationDefinitionsRegistry {
    @SubscribeEvent
    public static void registerAnimations(AnimationDefinitions.GatherAnimationsEvent event) {
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_left"), ChangedAddonAnimationsDefinitions.DODGE_LEFT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_right"), ChangedAddonAnimationsDefinitions.DODGE_RIGHT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_down_left"), ChangedAddonAnimationsDefinitions.DODGE_DOWN_LEFT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_down_right"), ChangedAddonAnimationsDefinitions.DODGE_DOWN_RIGHT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_weave_left"), ChangedAddonAnimationsDefinitions.DODGE_WEAVE_LEFT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("dodge_weave_right"), ChangedAddonAnimationsDefinitions.DODGE_WEAVE_RIGHT, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
        event.addAnimationDefinition(ChangedAddonMod.resourceLoc("pat_reaction"), ChangedAddonAnimationsDefinitions.PATTED_SLOW, AnimationDefinitions.GatherAnimationsEvent.OverridePolicy.OVERRIDE_JSON);
    }
}
