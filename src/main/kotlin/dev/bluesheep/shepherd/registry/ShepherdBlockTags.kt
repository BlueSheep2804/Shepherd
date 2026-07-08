package dev.bluesheep.shepherd.registry

import dev.bluesheep.shepherd.Shepherd.rl
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

object ShepherdBlockTags {
    val INFINITE_GRASS: TagKey<Block> = TagKey.create(Registries.BLOCK, rl("infinite_grass"))
}