package net.foxyas.changedaddon.client.renderer.mobs;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.model.PrototypeModel;
import net.foxyas.changedaddon.entity.simple.PrototypeEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.*;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class PrototypeRenderer extends AdvancedHumanoidRenderer<PrototypeEntity, PrototypeModel, ArmorLatexMaleWolfModel<PrototypeEntity>> {
    public PrototypeRenderer(EntityRendererProvider.Context context) {
        super(context, new PrototypeModel(context.bakeLayer(PrototypeModel.LAYER_LOCATION)),
                ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new EmissiveBodyLayer<>(this, ChangedAddonMod.textureLoc("textures/entities/prototype/prototype_glowing_layer")));
        this.addLayer(new CustomEyesLayer<>(this, context.getModelSet(), CustomEyesLayer::scleraColor, CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight));
        this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
    }

    @Override
    public ResourceLocation getTextureLocation(PrototypeEntity entity) {
        return ChangedAddonMod.textureLoc("textures/entities/prototype/prototype_base_layer");
    }
}
