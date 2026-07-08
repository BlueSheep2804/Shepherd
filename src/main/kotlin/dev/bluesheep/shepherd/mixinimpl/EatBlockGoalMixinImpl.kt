package dev.bluesheep.shepherd.mixinimpl

import dev.bluesheep.shepherd.registry.ShepherdBlockTags
import net.minecraft.core.BlockPos
import net.minecraft.world.level.Level

object EatBlockGoalMixinImpl {
    @JvmStatic
    fun modifyCanUseBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos.below()).`is`(ShepherdBlockTags.INFINITE_GRASS)
    }

    @JvmStatic
    fun modifyTickBlockState(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        return original || level.getBlockState(blockPos).`is`(ShepherdBlockTags.INFINITE_GRASS)
    }

    @JvmStatic
    fun modifyTickCanEntityGrief(original: Boolean, level: Level, blockPos: BlockPos): Boolean {
        if (level.getBlockState(blockPos).`is`(ShepherdBlockTags.INFINITE_GRASS)) return false
        return original
    }
}