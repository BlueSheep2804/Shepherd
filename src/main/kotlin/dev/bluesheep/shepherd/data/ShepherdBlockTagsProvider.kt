package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.Shepherd
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ShepherdBlockTagsProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper
) : BlockTagsProvider(output, lookupProvider, Shepherd.MODID, existingFileHelper) {
    override fun addTags(p0: HolderLookup.Provider) {}
}
