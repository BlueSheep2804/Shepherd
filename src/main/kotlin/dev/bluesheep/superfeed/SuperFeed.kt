package dev.bluesheep.superfeed

import com.mojang.logging.LogUtils
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import org.slf4j.Logger

@Mod(SuperFeed.MODID)
@EventBusSubscriber(modid = SuperFeed.MODID)
object SuperFeed {
    const val MODID: String = "superfeed"
    val LOGGER: Logger = LogUtils.getLogger()

    @SubscribeEvent
    fun commonSetup(event: FMLCommonSetupEvent) {}
}
