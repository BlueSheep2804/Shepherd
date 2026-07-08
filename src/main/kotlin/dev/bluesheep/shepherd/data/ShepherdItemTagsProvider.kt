package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.Shepherd
import dev.bluesheep.shepherd.registry.ShepherdItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ShepherdItemTagsProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
    existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, lookupProvider, blockTags, Shepherd.MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ItemTags.SHEEP_FOOD)
            .add(ShepherdItems.SUPER_WHEAT)
    }
}