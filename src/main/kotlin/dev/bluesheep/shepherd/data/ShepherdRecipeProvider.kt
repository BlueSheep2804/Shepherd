package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.registry.ShepherdItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.Items
import java.util.concurrent.CompletableFuture

class ShepherdRecipeProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) : RecipeProvider(output, registries) {
    override fun buildRecipes(recipeOutput: RecipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ShepherdItems.SUPER_WHEAT)
            .requires(Items.WHEAT)
            .requires(Items.GLOW_BERRIES, 4)
            .unlockedBy("has_wheat", has(Items.WHEAT))
            .save(recipeOutput)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ShepherdItems.SUPER_GRASS_BLOCK)
            .requires(Items.GRASS_BLOCK)
            .requires(ShepherdItems.SUPER_WHEAT)
            .unlockedBy("has_super_wheat", has(ShepherdItems.SUPER_WHEAT))
            .save(recipeOutput)
    }
}