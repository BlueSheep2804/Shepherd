package dev.bluesheep.superfeed

import com.mojang.logging.LogUtils
import dev.bluesheep.superfeed.data.SuperFeedBlockTagsProvider
import dev.bluesheep.superfeed.data.SuperFeedItemTagsProvider
import dev.bluesheep.superfeed.registry.SuperFeedItems
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.data.event.GatherDataEvent
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(SuperFeed.MODID)
@EventBusSubscriber(modid = SuperFeed.MODID)
object SuperFeed {
    const val MODID: String = "superfeed"
    val LOGGER: Logger = LogUtils.getLogger()

    init {
        SuperFeedItems.REGISTRY.register(MOD_BUS)
        SuperFeedItems.CREATIVE_TAB_REGISTRY.register(MOD_BUS)
    }

    @SubscribeEvent
    fun commonSetup(event: FMLCommonSetupEvent) {}

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val packOutput = event.generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val blockTags = SuperFeedBlockTagsProvider(packOutput, event.lookupProvider, existingFileHelper)
        event.addProvider(blockTags)
        event.addProvider(SuperFeedItemTagsProvider(packOutput, event.lookupProvider, blockTags.contentsGetter(), existingFileHelper))
    }
}
