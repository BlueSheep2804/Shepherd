package dev.bluesheep.shepherd.registry

import dev.bluesheep.shepherd.Shepherd
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ShepherdBlocks {
    val REGISTRY: DeferredRegister.Blocks = DeferredRegister.createBlocks(Shepherd.MODID)

    val SUPER_GRASS_BLOCK: Block by REGISTRY.registerSimpleBlock("super_grass_block", BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK))
}