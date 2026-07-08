package dev.bluesheep.superfeed.registry

import dev.bluesheep.superfeed.SuperFeed
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object SuperFeedBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(SuperFeed.MODID)

    val SUPER_GRASS_BLOCK: Block by REGISTRY.registerSimpleBlock("super_grass_block")
}