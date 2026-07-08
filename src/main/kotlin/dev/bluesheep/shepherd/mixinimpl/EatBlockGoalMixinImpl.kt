package dev.bluesheep.shepherd.mixinimpl

import dev.bluesheep.shepherd.registry.ShepherdBlocks
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

object EatBlockGoalMixinImpl {
    @JvmStatic
    fun modifyCanUseBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos.below()).`is`(ShepherdBlocks.SUPER_GRASS_BLOCK)
    }

    @JvmStatic
    fun modifyTickBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos).`is`(ShepherdBlocks.SUPER_GRASS_BLOCK)
    }

    @JvmStatic
    fun modifyTickCanEntityGrief(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        if (level.getBlockState(blockPos).`is`(ShepherdBlocks.SUPER_GRASS_BLOCK)) return false
        return original
    }
}