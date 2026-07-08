package dev.bluesheep.shepherd.registry

import dev.bluesheep.shepherd.Shepherd
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ShepherdItems {
    val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(Shepherd.MODID)

    val SUPER_WHEAT: Item by REGISTRY.registerSimpleItem("super_wheat")

    val SUPER_GRASS_BLOCK: BlockItem by REGISTRY.registerSimpleBlockItem("super_grass_block") { ShepherdBlocks.SUPER_GRASS_BLOCK }

    val CREATIVE_TAB_REGISTRY: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Shepherd.MODID)
    val TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_TAB_REGISTRY.register("tab") { ->
        CreativeModeTab.builder()
            .icon { SUPER_WHEAT.defaultInstance }
            .displayItems(REGISTRY.entries)
            .build()
    }
}
