package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.Shepherd
import dev.bluesheep.shepherd.registry.ShepherdBlocks
import dev.bluesheep.shepherd.registry.ShepherdItems
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.client.model.generators.ModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ShepherdItemModelProvider(
    output: PackOutput,
    existingFileHelper: ExistingFileHelper
) : ItemModelProvider(output, Shepherd.MODID, existingFileHelper) {
    override fun registerModels() {
        getBuilder(BuiltInRegistries.ITEM.getKey(ShepherdItems.SUPER_WHEAT).toString())
            .parent(ModelFile.UncheckedModelFile(mcLoc("item/wheat")))

        simpleBlockItem(ShepherdBlocks.SUPER_GRASS_BLOCK)
    }
}