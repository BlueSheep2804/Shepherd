package dev.bluesheep.examplemod

import com.mojang.logging.LogUtils
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import org.slf4j.Logger

@Mod(ExampleMod.MODID)
@EventBusSubscriber(modid = ExampleMod.MODID)
object ExampleMod {
    const val MODID: String = "examplemod"
    val LOGGER: Logger = LogUtils.getLogger()

    @SubscribeEvent
    fun commonSetup(event: FMLCommonSetupEvent) {}
}
