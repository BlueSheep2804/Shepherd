package dev.bluesheep.superfeed.registry

import dev.bluesheep.superfeed.SuperFeed
import net.minecraft.core.registries.Registries
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object SuperFeedItems {
    val REGISTRY: DeferredRegister.Items = DeferredRegister.createItems(SuperFeed.MODID)

    val SUPER_WHEAT: Item by REGISTRY.registerSimpleItem("super_wheat")

    val CREATIVE_TAB_REGISTRY: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SuperFeed.MODID)
    val TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_TAB_REGISTRY.register("tab") { ->
        CreativeModeTab.builder()
            .icon { SUPER_WHEAT.defaultInstance }
            .displayItems(REGISTRY.entries)
            .build()
    }
}
