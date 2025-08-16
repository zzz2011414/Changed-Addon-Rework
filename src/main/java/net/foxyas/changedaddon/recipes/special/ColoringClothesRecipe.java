package net.foxyas.changedaddon.recipes.special;

import com.google.gson.JsonObject;
import net.foxyas.changedaddon.init.ChangedAddonItems;
import net.foxyas.changedaddon.item.clothes.DyeableShorts;
import net.foxyas.changedaddon.item.clothes.TShirtClothing;
import net.foxyas.changedaddon.item.clothes.DyeableSportsBra;
import net.foxyas.changedaddon.item.clothes.TShirtClothing;
import net.foxyas.changedaddon.recipes.ChangedAddonModRecipeTypes;
import net.ltxprogrammer.changed.item.BenignShorts;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ColoringClothesRecipe extends CustomRecipe {
    public ColoringClothesRecipe(ResourceLocation id) {
        super(id);
    }

    @Override
    public boolean matches(CraftingContainer container, @NotNull Level level) {
        boolean hasClothing = false;
        boolean hasDye = false;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();

                // Aceitar shorts, camisetas e sports bras
                if (item == ChangedAddonItems.DYEABLE_SHORTS.get() ||
                        item instanceof DyeableShorts ||
                        item instanceof BenignShorts ||
                        item instanceof TShirtClothing ||
                        item instanceof DyeableSportsBra) {

                    if (hasClothing) return false; // só pode 1 peça por vez
                    hasClothing = true;

                } else if (item instanceof DyeItem) {
                    hasDye = true;
                } else {
                    return false;
                }
            }
        }

        return hasClothing && hasDye;
    }

    @Override
    public @NotNull ItemStack assemble(CraftingContainer container) {
        ItemStack clothing = ItemStack.EMPTY;

        int totalR = 0;
        int totalG = 0;
        int totalB = 0;
        int dyeCount = 0;

        for (int i = 0; i < container.getContainerSize(); ++i) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) {
                Item item = stack.getItem();

                if (item == ChangedAddonItems.DYEABLE_SHORTS.get() ||
                        item instanceof DyeableShorts ||
                        item instanceof BenignShorts ||
                        item instanceof TShirtClothing ||
                        item instanceof DyeableSportsBra) {

                    clothing = stack;

                } else if (item instanceof DyeItem dyeItem) {
                    int color = dyeItem.getDyeColor().getTextColor(); // 0xRRGGBB
                    totalR += (color >> 16) & 0xFF;
                    totalG += (color >> 8) & 0xFF;
                    totalB += color & 0xFF;
                    dyeCount++;
                }
            }
        }

        if (!clothing.isEmpty() && dyeCount > 0) {
            int r = totalR / dyeCount;
            int g = totalG / dyeCount;
            int b = totalB / dyeCount;
            int finalColor = (r << 16) | (g << 8) | b;

            ItemStack result = clothing.copy();
            result.setCount(1);

            if (result.getItem() instanceof DyeableLeatherItem dyeableLeatherItem) {
                dyeableLeatherItem.setColor(result, finalColor);
            } else if (result.getItem() instanceof BenignShorts) {
                // converter shorts "não-dyeable" em dyeable
                ItemStack backUp = result;
                result = new ItemStack(ChangedAddonItems.DYEABLE_SHORTS.get(), backUp.getCount());
                result.setTag(backUp.getTag());
                if (result.getItem() instanceof DyeableLeatherItem dyeableLeatherItem) {
                    dyeableLeatherItem.setColor(result, finalColor);
                }
            }

            return result;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return ChangedAddonModRecipeTypes.COLORING_CLOTHES.get();
    }

    public static class Serializer implements RecipeSerializer<ColoringClothesRecipe> {

        public static final ResourceLocation ID = new ResourceLocation("changed_addon", "coloring_clothes");

        @Override
        public @NotNull ColoringClothesRecipe fromJson(@NotNull ResourceLocation id, @NotNull JsonObject json) {
            return new ColoringClothesRecipe(id);
        }

        @Override
        public ColoringClothesRecipe fromNetwork(@NotNull ResourceLocation id, @NotNull FriendlyByteBuf buffer) {
            return new ColoringClothesRecipe(id);
        }

        @Override
        public void toNetwork(@NotNull FriendlyByteBuf buffer, @NotNull ColoringClothesRecipe recipe) {
            // Nada a enviar
        }

        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return this;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return (Class<RecipeSerializer<?>>) (Class<?>) RecipeSerializer.class;
        }
    }

}
