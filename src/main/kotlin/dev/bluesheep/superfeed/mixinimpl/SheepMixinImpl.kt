package dev.bluesheep.superfeed.mixinimpl

import dev.bluesheep.superfeed.registry.SuperFeedItems.SUPER_WHEAT
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.animal.Sheep
import net.minecraft.world.entity.player.Player

object SheepMixinImpl {
    @JvmStatic
    fun injectMobInteract(sheep: Sheep, player: Player, hand: InteractionHand): InteractionResult? {
        val item = player.getItemInHand(hand)
        if (item.`is`(SUPER_WHEAT)) {
            if (sheep.getAge() >= 0 && sheep.isSheared) {
                if (!player.level().isClientSide) {
                    sheep.isSheared = false
                    item.consume(1, player)
                    return InteractionResult.SUCCESS
                } else {
                    return InteractionResult.CONSUME
                }
            } else {
                return InteractionResult.PASS
            }
        }
        return null
    }
}