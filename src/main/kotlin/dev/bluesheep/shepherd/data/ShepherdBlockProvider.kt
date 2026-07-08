package dev.bluesheep.shepherd.data

import dev.bluesheep.shepherd.Shepherd
import dev.bluesheep.shepherd.registry.ShepherdBlocks
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class ShepherdBlockProvider(output: PackOutput, exFileHelper: ExistingFileHelper) : BlockStateProvider(output, Shepherd.MODID, exFileHelper) {
    override fun registerStatesAndModels() {
        simpleBlock(
            ShepherdBlocks.SUPER_GRASS_BLOCK,
            models().withExistingParent(
                BuiltInRegistries.BLOCK.getKey(ShepherdBlocks.SUPER_GRASS_BLOCK).path,
                mcLoc("block/grass_block")
            )
                .renderType("cutout")
        )
    }
}