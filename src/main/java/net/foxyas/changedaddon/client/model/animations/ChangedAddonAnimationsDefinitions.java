package net.foxyas.changedaddon.client.model.animations;

import net.ltxprogrammer.changed.client.animations.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChangedAddonAnimationsDefinitions {

    public static final AnimationDefinition DODGE_RIGHT = AnimationDefinition.Builder.withLength(1.0F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.9923F, 34.8475F, -6.0963F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.9923F, 34.8475F, -6.0963F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-4.9128F, -0.0027F, -2.6685F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            /*.addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))*/
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(27.4F, 33.36F, 35.27F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(34.1175F, 76.1026F, 43.5856F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(34.1175F, 76.1026F, 43.5856F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(19.8245F, 68.4326F, 32.0297F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(13.8114F, 34.6956F, 14.5842F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(1.0F, 1.0F, 2.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(2.0F, 0.0F, 5.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(2.0F, 0.0F, 5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(2.0F, 0.0F, 6.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(1.0F, 2.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-18.569F, 32.0287F, 5.7233F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-35.0F, 55.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-12.5F, 55.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.852F, 27.8631F, 5.6318F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(4.11F, -0.26F, 5.88F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(7.0F, -2.1F, 7.2F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(3.3F, -0.7F, 4.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(2.38F, 0.5F, 2.44F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-23.9568F, -32.6146F, -9.0322F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-58.6686F, -34.124F, 20.1612F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.6324F, 13.0988F, -11.5125F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(2.3F, -0.2F, 2.2F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(3.0F, -3.0F, 1.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(1.07F, -0.42F, 0.88F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(10.4543F, 45.3884F, 62.5875F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(104.64F, 60.0822F, 142.0518F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(66.3305F, 71.08F, 76.8416F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(4.2443F, 34.8441F, 16.2393F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(3.7F, 0.0F, 7.9F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(9.2F, -1.7F, 11.2F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(5.5F, -0.7F, 8.7F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(2.6F, 0.6F, 4.9F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.1728F, 9.0386F, 19.7416F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-2.5248F, 13.5239F, 34.9889F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-3.5944F, 9.3523F, 17.2402F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.2802F, 4.2248F, 7.3183F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(3.5F, 0.1F, 4.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(7.1F, -2.0F, 6.1F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(4.19F, -0.66F, 4.65F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(2.36F, 0.11F, 1.69F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .build();

    public static final AnimationDefinition DODGE_LEFT = AnimationDefinition.Builder.withLength(1.0F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(27.4F, -33.36F, -35.27F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(34.1175F, -76.1026F, -43.5856F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(34.1175F, -76.1026F, -43.5856F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(19.8245F, -68.4326F, -32.0297F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(13.8114F, -34.6956F, -14.5842F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(-1.0F, 1.0F, 2.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-2.0F, 0.0F, 5.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-2.0F, 0.0F, 5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-2.0F, 0.0F, 6.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(-1.0F, 2.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-5.9923F, -34.8475F, 6.0963F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.9923F, -34.8475F, 6.0963F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-4.9128F, 0.0027F, 2.6685F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            /*.addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))*/
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-18.569F, -32.0287F, -5.7233F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-35.0F, -55.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-12.5F, -55.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.852F, -27.8631F, -5.6318F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-4.11F, -0.26F, 5.88F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-7.0F, -2.1F, 7.2F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(-3.3F, -0.7F, 4.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-2.38F, 0.5F, 2.44F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(10.4543F, -45.3884F, -62.5875F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(104.64F, -60.0822F, -142.0518F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(66.3305F, -71.08F, -76.8416F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(4.2443F, -34.8441F, -16.2393F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-3.7F, 0.0F, 7.9F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-9.2F, -1.7F, 11.2F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(-5.5F, -0.7F, 8.7F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-2.6F, 0.6F, 4.9F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-23.9568F, 32.6146F, 9.0322F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-58.6686F, 34.124F, -20.1612F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.6324F, -13.0988F, 11.5125F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(-2.3F, -0.2F, 2.2F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-3.0F, -3.0F, 1.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-1.07F, -0.42F, 0.88F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-2.1728F, -9.0386F, -19.7416F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-2.5248F, -13.5239F, -34.9889F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-3.5944F, -9.3523F, -17.2402F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.2802F, -4.2248F, -7.3183F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(-3.5F, 0.1F, 4.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-7.1F, -2.0F, 6.1F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(-4.19F, -0.66F, 4.65F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-2.36F, 0.11F, 1.69F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .build();

    public static final AnimationDefinition BOSS_DODGE_DOWN_RIGHT = AnimationDefinition.Builder.withLength(1.0F)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(38.6409F, -8.823F, -11.8598F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(38.6409F, -8.823F, -11.8598F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(52.5721F, -9.1498F, -12.299F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(31.1409F, -8.823F, -11.8598F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(-0.47F, -2.35F, 2.2F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-0.9F, -2.6F, 2.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-1.6F, -2.2F, 2.9F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(-1.14F, -4.39F, 0.57F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.1F, -2.6F, -4.5F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.875F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -2.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -2.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, -4.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.875F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(61.1616F, -8.6474F, -15.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(61.1616F, -8.6474F, -15.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-1.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(50.4747F, 16.7893F, -17.4564F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(50.4747F, 16.7893F, -17.4564F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(26.1293F, 17.8387F, -18.5475F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-0.8386F, 5.4359F, -13.2282F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, -7.0F, -5.6F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, -7.9F, -6.7F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-1.0F, -7.0F, -5.6F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, -12.0F, -6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, -12.0F, -6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-1.0F, -12.0F, -6.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(102.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -8.0F, -8.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -8.4F, -8.9F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, -8.0F, -8.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .build();
        
    public static final AnimationDefinition DODGE_DOWN_RIGHT = AnimationDefinition.Builder.withLength(1.125F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(14.9858F, -0.3264F, 3.7358F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(14.9858F, -0.3264F, 3.7358F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(9.9994F, -0.4065F, 4.2301F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-0.5454F, -0.4471F, 4.4823F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-8.5945F, -0.468F, 4.569F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-6.6611F, -0.455F, 3.9809F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.67F, 0.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(16.3977F, 0.9837F, -3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(46.3977F, 0.9837F, -3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(56.3977F, 0.9837F, -3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(63.8977F, 0.9837F, -3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(61.3977F, 0.9837F, -3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.93F, 0.66F, -2.49F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(1.0F, -5.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(1.0F, -5.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.67F, -3.33F, 1.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -8.0F, -6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -9.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -9.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -4.67F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-22.8924F, 9.0866F, 26.0666F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-45.3924F, 9.0866F, 26.0666F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-53.5496F, 19.2743F, 33.5493F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-51.0496F, 19.2743F, 33.5493F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-34.46F, 16.83F, 25.64F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(3.0F, -9.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(3.0F, -9.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(2.0F, -4.0F, -0.67F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-37.0772F, -6.0681F, -7.9634F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(38.7618F, -16.728F, 2.4751F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(62.6007F, -27.3879F, 12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(104.6007F, -27.3879F, 12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(109.6007F, -27.3879F, 12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(73.07F, -18.26F, 8.61F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0833F, KeyframeAnimations.posVec(-1.0F, -3.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-1.0F, -3.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-1.0F, -3.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.67F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(14.9772F, 0.0405F, -0.474F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(69.9772F, 0.0405F, -0.474F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(90.1491F, -6.419F, 12.0534F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(92.6491F, -6.419F, 12.0534F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.76F, 0.03F, -0.32F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -8.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition DODGE_DOWN_LEFT = AnimationDefinition.Builder.withLength(1.125F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(16.3977F, -0.9837F, 3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(46.3977F, -0.9837F, 3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(56.3977F, -0.9837F, 3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(63.8977F, -0.9837F, 3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(61.3977F, -0.9837F, 3.7359F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.93F, -0.66F, 2.49F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -1.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(-1.0F, -5.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(-1.0F, -5.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.67F, -3.33F, 1.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(14.9858F, 0.3264F, -3.7358F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(14.9858F, 0.3264F, -3.7358F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(9.9994F, 0.4065F, -4.2301F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(-0.5454F, 0.4471F, -4.4823F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-8.5945F, 0.468F, -4.569F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-6.6611F, 0.455F, -3.9809F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.posVec(-0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(-0.75F, -2.0F, -7.75F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-0.67F, 0.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(57.5F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(60.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -8.0F, -6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -9.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -9.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -4.67F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            /*.addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.SCALE,
                    new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.scaleVec(1.0F, 1.0F, 1.0F), AnimationChannel.Interpolation.LINEAR)
            ))*/
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-37.0772F, 6.0681F, 7.9634F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(38.7618F, 16.728F, -2.4751F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(62.6007F, 27.3879F, -12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(104.6007F, 27.3879F, -12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(109.6007F, 27.3879F, -12.9137F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(73.07F, 18.26F, -8.61F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0833F, KeyframeAnimations.posVec(1.0F, -3.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(1.0F, -3.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(1.0F, -3.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.67F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-22.8924F, -9.0866F, -26.0666F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-45.3924F, -9.0866F, -26.0666F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-53.5496F, -19.2743F, -33.5493F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-51.0496F, -19.2743F, -33.5493F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-34.46F, -16.83F, -25.64F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -3.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-3.0F, -9.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-3.0F, -9.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-2.0F, -4.0F, -0.67F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(14.9772F, -0.0405F, 0.474F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(69.9772F, -0.0405F, 0.474F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(90.1491F, 6.419F, -12.0534F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(92.6491F, 6.419F, -12.0534F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(40.76F, -0.03F, 0.32F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.degreeVec(-15.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -2.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, -8.0F, -7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -9.0F, -8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, -4.0F, -3.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition DODGE_WEAVE_RIGHT = AnimationDefinition.Builder.withLength(1.1667F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 5.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(10.5919F, 19.7613F, 2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(10.5919F, 19.7613F, 2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(10.5919F, 19.7613F, 2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.4F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, 0.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(-1.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(-1.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(12.6044F, 7.3212F, 1.6322F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(32.9329F, 11.9321F, 3.5944F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(28.46F, 20.9241F, -12.082F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(37.2218F, 24.9398F, -8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(39.7218F, 24.9398F, -8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(39.7218F, 24.9398F, -8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -1.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -3.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -3.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.564F, 7.4355F, -0.9845F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-34.0487F, 41.5638F, -9.3392F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-70.0445F, 48.3824F, -28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-80.0445F, 48.3824F, -28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-85.0445F, 48.3824F, -28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-85.0445F, 48.3824F, -28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-61.6963F, 32.2549F, -18.8757F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(2.0F, 0.0F, 6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(5.0F, -4.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(5.0F, -5.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(5.0F, -6.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(5.0F, -6.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(3.33F, -5.0F, 7.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(1.11F, -1.67F, 3.11F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-15.4447F, 20.6581F, -21.4169F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-25.4447F, 20.6581F, -21.4169F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-28.5016F, 42.7726F, -38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-21.0016F, 42.7726F, -38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-21.0016F, 42.7726F, -38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(1.0F, 0.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(2.0F, -2.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(2.0F, -3.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(2.0F, -3.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-12.5462F, 4.8812F, 11.4152F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-32.4564F, 2.7726F, 12.7614F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-31.6102F, 33.6064F, 92.3389F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(20.3962F, 29.4466F, 114.8687F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(29.2307F, 12.1837F, 54.5117F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(12.1717F, 30.4073F, 3.9961F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(9.2324F, 31.3366F, -1.7285F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(9.2324F, 31.3366F, -1.7285F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(19.9279F, 22.3833F, -1.2346F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(30.2757F, 17.9067F, -0.9877F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(-1.0F, 0.0F, 7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(2.0F, -3.0F, 10.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(4.0F, -6.0F, 12.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(4.0F, -6.0F, 12.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.7431F, 17.4339F, -1.0232F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-28.2884F, 30.847F, -8.4097F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-95.7464F, 34.8596F, -45.6406F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-120.0743F, 31.3425F, -53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-130.0743F, 31.3425F, -53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-130.0743F, 31.3425F, -53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(2.0F, 1.0F, 7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(6.0F, -3.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(6.0F, -5.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(6.0F, -5.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition DODGE_WEAVE_LEFT = AnimationDefinition.Builder.withLength(1.1667F).withTransition(0)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(12.6044F, -7.3212F, -1.6322F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(32.9329F, -11.9321F, -3.5944F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(28.46F, -20.9241F, 12.082F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(37.2218F, -24.9398F, 8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(39.7218F, -24.9398F, 8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(39.7218F, -24.9398F, 8.8464F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, -1.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, -3.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -3.0F, 4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, -5.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(10.5919F, -19.7613F, -2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(10.5919F, -19.7613F, -2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(10.5919F, -19.7613F, -2.7372F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.4F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(1.0F, 0.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.posVec(1.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(1.0F, 0.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.564F, -7.4355F, 0.9845F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-34.0487F, -41.5638F, 9.3392F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-70.0445F, -48.3824F, 28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-80.0445F, -48.3824F, 28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-85.0445F, -48.3824F, 28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-85.0445F, -48.3824F, 28.3135F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-61.6963F, -32.2549F, 18.8757F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-2.0F, 0.0F, 6.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-5.0F, -4.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(-5.0F, -5.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(-5.0F, -6.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.posVec(-5.0F, -6.0F, 8.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.posVec(-3.33F, -5.0F, 7.33F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.9583F, KeyframeAnimations.posVec(-1.11F, -1.67F, 3.11F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-12.5462F, -4.8812F, -11.4152F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.degreeVec(-32.4564F, -2.7726F, -12.7614F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-31.6102F, -33.6064F, -92.3389F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(20.3962F, -29.4466F, -114.8687F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(29.2307F, -12.1837F, -54.5117F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(12.1717F, -30.4073F, -3.9961F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(9.2324F, -31.3366F, 1.7285F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(9.2324F, -31.3366F, 1.7285F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(19.9279F, -22.3833F, 1.2346F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.9167F, KeyframeAnimations.degreeVec(30.2757F, -17.9067F, 0.9877F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.125F, KeyframeAnimations.posVec(1.0F, 0.0F, 7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-2.0F, -3.0F, 10.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(-4.0F, -6.0F, 12.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-4.0F, -6.0F, 12.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-15.4447F, -20.6581F, 21.4169F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-25.4447F, -20.6581F, 21.4169F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-28.5016F, -42.7726F, 38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-21.0016F, -42.7726F, 38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.degreeVec(-21.0016F, -42.7726F, 38.7174F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-1.0F, 0.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-2.0F, -2.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.posVec(-2.0F, -3.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7083F, KeyframeAnimations.posVec(-2.0F, -3.0F, 2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.7431F, -17.4339F, 1.0232F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-28.2884F, -30.847F, 8.4097F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-95.7464F, -34.8596F, 45.6406F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(-120.0743F, -31.3425F, 53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(-130.0743F, -31.3425F, 53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.degreeVec(-130.0743F, -31.3425F, 53.5528F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-2.0F, 1.0F, 7.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-6.0F, -3.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(-6.0F, -5.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.75F, KeyframeAnimations.posVec(-6.0F, -5.0F, 9.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition PATTED_SLOW = AnimationDefinition.Builder.withLength(2.0833F).withTransition(0)
            .addAnimation(ModelPartIdentifier.forExtension(LimbExtensions.RIGHT_EAR, "RightEarPivot"), new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -12.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(ModelPartIdentifier.forExtension(LimbExtensions.LEFT_EAR, "LeftEarPivot"), new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(ModelPartIdentifier.forExtension(LimbExtensions.TAIL, "Primary"), new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 14.87F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 16.87F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(0.0F, 17.37F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 15.37F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 10.37F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.3333F, KeyframeAnimations.degreeVec(0.0F, -27.26F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -28.33F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.4583F, KeyframeAnimations.degreeVec(0.0F, -25.83F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -12.5F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(ModelPartIdentifier.forExtension(LimbExtensions.TAIL, "TailSecondary"), new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 13.89F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 19.89F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(0.0F, 24.89F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5417F, KeyframeAnimations.degreeVec(0.0F, 30.39F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.625F, KeyframeAnimations.degreeVec(0.0F, 31.75F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.0F, 29.88F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.0F, 22.39F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.2083F, KeyframeAnimations.degreeVec(0.0F, -13.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.375F, KeyframeAnimations.degreeVec(0.0F, -23.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(ModelPartIdentifier.forExtension(LimbExtensions.TAIL, "TailTertiary"), new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 16.34F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 21.84F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 26.84F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0.0F, 29.34F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.7917F, KeyframeAnimations.degreeVec(0.0F, 33.2F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -18.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0.0F, -27.5F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.5833F, KeyframeAnimations.degreeVec(0.0F, -32.5F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, -29.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(2.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition OLD_DODGE_WEAVE = AnimationDefinition.Builder.withLength(0.5F).withTransition(0f)
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(16.0F, 14.0F, -3.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.25F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-7.0F, 10.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.2F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(10.0F, 10.0F, -5.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 1.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-16.0F, -7.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.9F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(4.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.9F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();
    public static final AnimationDefinition OLD_DODGE_LEFT = AnimationDefinition.Builder.withLength(0.5F).withTransition(0f)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(5.25F, -26.31F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(20.3356F, -36.5204F, -11.9884F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(48.2844F, -64.9128F, -52.092F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(48.2844F, -64.9128F, -52.092F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(28.291F, -44.0637F, -35.1278F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.21F, -0.07F, 2.84F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-6.4F, -0.4F, 3.1F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-6.4F, -0.4F, 3.1F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(-4.16F, -0.34F, 2.49F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.8698F, -20.5492F, -0.5652F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-4.6693F, -41.78F, -1.813F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-11.6481F, -17.4154F, -3.0488F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-11.6481F, -17.4154F, -3.0488F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(0.19F, -0.23F, -0.91F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-2.7F, -1.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-2.7F, -1.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(33.2318F, -39.4556F, -19.2452F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(50.6685F, -60.158F, -28.9726F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(50.6685F, -60.158F, -28.9726F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.0228F, -53.9232F, -26.4566F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(37.2766F, -49.2053F, -22.5815F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(14.8067F, -28.6223F, -5.9259F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0833F, KeyframeAnimations.posVec(-0.53F, -0.95F, -3.57F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-1.0F, -2.0F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-1.0F, -2.0F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(-1.03F, -1.07F, -2.56F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(-0.82F, -0.48F, -1.16F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(72.5882F, -29.8029F, -56.1268F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(72.5882F, -29.8029F, -56.1268F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-4.1F, 0.0F, 1.6F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-4.1F, 0.0F, 1.6F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-29.6378F, -32.9421F, 11.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-29.6378F, -32.9421F, 11.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(2.3F, -4.2F, -9.7F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(2.3F, -4.2F, -9.7F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(75.8049F, -60.7506F, -65.6208F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(75.8049F, -60.7506F, -65.6208F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-2.1F, -1.3F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-2.1F, -1.3F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();

    public static final AnimationDefinition OLD_DODGE_RIGHT = AnimationDefinition.Builder.withLength(0.5F).withTransition(0f)
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-1.8698F, 20.5492F, 0.5652F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(-4.6693F, 41.78F, 1.813F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-11.6481F, 17.4154F, 3.0488F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-11.6481F, 17.4154F, 3.0488F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.LEFT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(-0.19F, -0.23F, -0.91F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(2.7F, -1.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(2.7F, -1.0F, -4.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0417F, KeyframeAnimations.degreeVec(5.25F, 26.31F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(20.3356F, 36.5204F, 11.9884F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(48.2844F, 64.9128F, 52.092F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(48.2844F, 64.9128F, 52.092F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(28.291F, 44.0637F, 35.1278F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.RIGHT_LEG, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0417F, KeyframeAnimations.posVec(-0.21F, -0.07F, 2.84F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(6.4F, -0.4F, 3.1F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(6.4F, -0.4F, 3.1F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.2917F, KeyframeAnimations.posVec(4.16F, -0.34F, 2.49F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.0833F, KeyframeAnimations.degreeVec(33.2318F, 39.4556F, 19.2452F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(50.6685F, 60.158F, 28.9726F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(50.6685F, 60.158F, 28.9726F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.2917F, KeyframeAnimations.degreeVec(45.0228F, 53.9232F, 26.4566F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.375F, KeyframeAnimations.degreeVec(37.2766F, 49.2053F, 22.5815F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4167F, KeyframeAnimations.degreeVec(14.8067F, 28.6223F, 5.9259F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.TORSO, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.0833F, KeyframeAnimations.posVec(0.53F, -0.95F, -3.57F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(1.0F, -2.0F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.375F, KeyframeAnimations.posVec(1.03F, -1.07F, -2.56F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4167F, KeyframeAnimations.posVec(0.82F, -0.48F, -1.16F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-29.6378F, 32.9421F, -11.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(-29.6378F, 32.9421F, -11.2727F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.LEFT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(-2.3F, -4.2F, -9.7F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(-2.3F, -4.2F, -9.7F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(72.5882F, 29.8029F, 56.1268F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(72.5882F, 29.8029F, 56.1268F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.RIGHT_ARM, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(4.1F, 0.0F, 1.6F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(4.1F, 0.0F, 1.6F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.ROTATION,
                    new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.1667F, KeyframeAnimations.degreeVec(75.8049F, 60.7506F, 65.6208F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.25F, KeyframeAnimations.degreeVec(75.8049F, 60.7506F, 65.6208F), AnimationChannel.Interpolation.CATMULLROM),
                    new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.CATMULLROM)
            ))
            .addAnimation(Limb.HEAD, new AnimationChannel(AnimationChannel.Target.POSITION,
                    new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.1667F, KeyframeAnimations.posVec(2.1F, -1.3F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.25F, KeyframeAnimations.posVec(2.1F, -1.3F, -4.5F), AnimationChannel.Interpolation.LINEAR),
                    new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolation.LINEAR)
            ))
            .build();
}
