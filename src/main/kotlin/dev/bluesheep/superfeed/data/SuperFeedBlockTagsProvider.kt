package dev.bluesheep.superfeed.data

import dev.bluesheep.superfeed.SuperFeed
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class SuperFeedBlockTagsProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper
) : BlockTagsProvider(output, lookupProvider, SuperFeed.MODID, existingFileHelper) {
    override fun addTags(p0: HolderLookup.Provider) {}
}
