package dev.bluesheep.shepherd

import com.mojang.logging.LogUtils
import dev.bluesheep.shepherd.data.ShepherdBlockProvider
import dev.bluesheep.shepherd.data.ShepherdBlockTagsProvider
import dev.bluesheep.shepherd.data.ShepherdItemModelProvider
import dev.bluesheep.shepherd.data.ShepherdItemTagsProvider
import dev.bluesheep.shepherd.registry.ShepherdBlocks
import dev.bluesheep.shepherd.registry.ShepherdItems
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.GrassColor
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent
import net.neoforged.neoforge.data.event.GatherDataEvent
import org.slf4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(Shepherd.MODID)
@EventBusSubscriber(modid = Shepherd.MODID)
object Shepherd {
    const val MODID: String = "shepherd"
    val LOGGER: Logger = LogUtils.getLogger()

    init {
        ShepherdBlocks.REGISTRY.register(MOD_BUS)
        ShepherdItems.REGISTRY.register(MOD_BUS)
        ShepherdItems.CREATIVE_TAB_REGISTRY.register(MOD_BUS)
    }

    @SubscribeEvent
    fun commonSetup(event: FMLCommonSetupEvent) {}

    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val packOutput = event.generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val blockTags = ShepherdBlockTagsProvider(packOutput, event.lookupProvider, existingFileHelper)
        event.addProvider(blockTags)
        event.addProvider(ShepherdItemTagsProvider(packOutput, event.lookupProvider, blockTags.contentsGetter(), existingFileHelper))
        event.addProvider(ShepherdBlockProvider(packOutput, existingFileHelper))
        event.addProvider(ShepherdItemModelProvider(packOutput, existingFileHelper))
    }

    @SubscribeEvent
    fun registerBlockColorHandlers(event: RegisterColorHandlersEvent.Block) {
        event.register(
            { block, level, pos, tintIndex -> GrassColor.getDefaultColor() },
            ShepherdBlocks.SUPER_GRASS_BLOCK
        )
    }

    @SubscribeEvent
    fun registerItemColorHandlers(event: RegisterColorHandlersEvent.Item) {
        event.register(
            { stack, tintIndex -> GrassColor.getDefaultColor() },
            ShepherdItems.SUPER_GRASS_BLOCK
        )
    }

    fun rl(path: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, path)
    }
}
