package net.foxyas.changedaddon.client.renderer.advanced;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.model.PrototypeModel;
import net.foxyas.changedaddon.entity.advanced.PrototypeEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.CustomEyesLayer;
import net.ltxprogrammer.changed.client.renderer.layers.EmissiveBodyLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PrototypeRenderer extends AdvancedHumanoidRenderer<PrototypeEntity, PrototypeModel, ArmorLatexMaleWolfModel<PrototypeEntity>> {
    public PrototypeRenderer(EntityRendererProvider.Context context) {
        super(context, new PrototypeModel(context.bakeLayer(PrototypeModel.LAYER_LOCATION)),
                ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(new EmissiveBodyLayer<>(this, ChangedAddonMod.textureLoc("textures/entities/prototype/prototype_glowing_layer")));
        this.addLayer(CustomEyesLayer.builder(this, context.getModelSet())
                .withEyebrows(CustomEyesLayer::noRender)
                .withEyelashes(CustomEyesLayer::noRender)
                .withSclera(Color3.parseHex("#0e1216"))
                .withIris(CustomEyesLayer::glowingIrisColorLeft, CustomEyesLayer::glowingIrisColorRight)
                .build());
        this.addLayer(new GasMaskLayer<>(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PrototypeEntity entity) {
        return ChangedAddonMod.textureLoc("textures/entities/prototype/prototype_base_layer");
    }
}
