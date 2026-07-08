package dev.bluesheep.superfeed.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import dev.bluesheep.superfeed.mixinimpl.EatBlockGoalMixinImpl;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(EatBlockGoal.class)
public class EatBlockGoalMixin {
    @Shadow
    @Final
    private Level level;

    @ModifyExpressionValue(method = "canUse", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean modifyCanUseBlockState(boolean original, @Local BlockPos blockPos) {
        return EatBlockGoalMixinImpl.modifyCanUseBlockState(original, level, blockPos);
    }

    @ModifyExpressionValue(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z"))
    private boolean modifyTickBlockState(boolean original, @Local(ordinal = 1) BlockPos blockPos) {
        return EatBlockGoalMixinImpl.modifyTickBlockState(original, level, blockPos);
    }

    @ModifyExpressionValue(
            method = "tick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/neoforged/neoforge/event/EventHooks;canEntityGrief(Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/Entity;)Z",
                    ordinal = 1
            )
    )
    private boolean modifyTickCanEntityGrief(boolean original, @Local(ordinal = 1) BlockPos blockPos) {
        return EatBlockGoalMixinImpl.modifyTickCanEntityGrief(original, level, blockPos);
    }
}
