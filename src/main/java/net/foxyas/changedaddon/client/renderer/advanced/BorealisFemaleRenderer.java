package net.foxyas.changedaddon.client.renderer.advanced;

import net.foxyas.changedaddon.ChangedAddonMod;
import net.foxyas.changedaddon.client.model.advanced.BorealisFemaleModel;
import net.foxyas.changedaddon.entity.advanced.BorealisFemaleEntity;
import net.ltxprogrammer.changed.client.renderer.AdvancedHumanoidRenderer;
import net.ltxprogrammer.changed.client.renderer.layers.EmissiveBodyLayer;
import net.ltxprogrammer.changed.client.renderer.layers.GasMaskLayer;
import net.ltxprogrammer.changed.client.renderer.layers.TransfurCapeLayer;
import net.ltxprogrammer.changed.client.renderer.model.armor.ArmorLatexMaleWolfModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class BorealisFemaleRenderer extends AdvancedHumanoidRenderer<BorealisFemaleEntity, BorealisFemaleModel, ArmorLatexMaleWolfModel<BorealisFemaleEntity>> {
    public BorealisFemaleRenderer(EntityRendererProvider.Context context) {
        super(context, new BorealisFemaleModel(context.bakeLayer(BorealisFemaleModel.LAYER_LOCATION)), ArmorLatexMaleWolfModel.MODEL_SET, 0.5f);
        /*this.addLayer(new ProtogenDisplay<>(this, getModel(),
                new ResourceLocation("changed_addon:textures/entities/borealis_male/protogen_eyes_display.png"),
                new ResourceLocation("changed_addon:textures/entities/borealis_male/protogen_display.png")));*/
        this.addLayer(new EmissiveBodyLayer<>(this, ChangedAddonMod.textureLoc("textures/entities/borealis_female/protogen_display")));
        this.addLayer(new EmissiveBodyLayer<>(this, ChangedAddonMod.textureLoc("textures/entities/borealis_female/protogen_eyes_display")));
        this.addLayer(TransfurCapeLayer.normalCape(this, context.getModelSet()));
        this.addLayer(GasMaskLayer.forLargeSnouted(this, context.getModelSet()));
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull BorealisFemaleEntity entity) {
        return ChangedAddonMod.textureLoc("textures/entities/borealis_female/borealis_female");
    }
}
