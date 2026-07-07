package dev.bluesheep.superfeed.data

import dev.bluesheep.superfeed.SuperFeed
import dev.bluesheep.superfeed.registry.SuperFeedItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class SuperFeedItemTagsProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
    existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, lookupProvider, blockTags, SuperFeed.MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ItemTags.SHEEP_FOOD)
            .add(SuperFeedItems.SUPER_WHEAT)
    }
}