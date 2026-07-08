package dev.bluesheep.shepherd.mixin;

import dev.bluesheep.shepherd.mixinimpl.SheepMixinImpl;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Sheep.class)
public class SheepMixin {
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    void injectMobInteract(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        var result = SheepMixinImpl.injectMobInteract((Sheep)(Object) this, player, hand);
        if (result != null) {
            cir.setReturnValue(result);
        }
    }
}
