package dev.bluesheep.superfeed.mixinimpl

import dev.bluesheep.superfeed.registry.SuperFeedBlocks
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

object EatBlockGoalMixinImpl {
    @JvmStatic
    fun modifyCanUseBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos.below()).`is`(SuperFeedBlocks.SUPER_GRASS_BLOCK)
    }

    @JvmStatic
    fun modifyTickBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos).`is`(SuperFeedBlocks.SUPER_GRASS_BLOCK)
    }

    @JvmStatic
    fun modifyTickCanEntityGrief(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        if (level.getBlockState(blockPos).`is`(SuperFeedBlocks.SUPER_GRASS_BLOCK)) return false
        return original
    }
}