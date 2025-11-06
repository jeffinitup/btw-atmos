package com.jeffyjamzhd.btwatmos.mixin;

import com.jeffyjamzhd.btwatmos.BTWAtmos;
import eu.ha3.matmos.game.system.MAtMod;
import com.jeffyjamzhd.btwatmos.shim.PortUtil;
import net.minecraft.src.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow private boolean isGamePaused;
    @Shadow private long prevFrameTime;

    @Inject(method = "startGame", at = @At(value = "INVOKE", target = "Lnet/minecraft/src/Minecraft;refreshResources()V", ordinal = 0))
    private void btwa$setup(CallbackInfo ci) {
        BTWAtmos.MATMOS.getAddon().onLoad();
    }

    @Inject(method = "runGameLoop", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        // Initialize (if needed)
        Minecraft mc = (Minecraft) (Object) this;
        if (!BTWAtmos.MATMOS.isLoaded()) {
            ((MAtMod) BTWAtmos.MATMOS.getAddon()).preInit();
            BTWAtmos.MATMOS.setLoaded(true);
        }
    }

    @Inject(method = "runTick", at = @At("TAIL"))
    private void updateInput(CallbackInfo ci) {
        // Handle input
        MAtMod addon = (MAtMod) BTWAtmos.MATMOS.getAddon();
        addon.userControl.onTick();

        // Update tick
        Minecraft mc = (Minecraft) (Object) this;
        boolean inGame = PortUtil.isInGame(mc);
        BTWAtmos.MATMOS.onTick(mc, this.prevFrameTime, inGame, !isGamePaused);
    }
}
