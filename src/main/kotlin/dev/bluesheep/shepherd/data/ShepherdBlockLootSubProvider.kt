package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.registry.ShepherdBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block

class ShepherdBlockLootSubProvider(
    lookupProvider: HolderLookup.Provider
) : BlockLootSubProvider(
    emptySet(),
    FeatureFlags.DEFAULT_FLAGS,
    lookupProvider
) {
    override fun getKnownBlocks(): Iterable<Block> {
        return ShepherdBlocks.REGISTRY.entries.map {
            it.value()
        }
    }

    override fun generate() {
        add(ShepherdBlocks.SUPER_GRASS_BLOCK) { block -> createSingleItemTableWithSilkTouch(block, Items.DIRT) }
    }
}