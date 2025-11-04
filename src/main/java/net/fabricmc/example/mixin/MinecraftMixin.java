package net.fabricmc.example.mixin;

import btw.community.example.BTWAtmos;
import eu.ha3.matmos.game.system.MAtMod;
import net.fabricmc.example.shim.PortUtil;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow private Timer timer;
    @Shadow private boolean isGamePaused;

    @Shadow private long prevFrameTime;

    @Inject(method = "runGameLoop", at = @At("TAIL"))
    private void init(CallbackInfo ci) {
        // Initialize (if needed)

        Minecraft mc = (Minecraft) (Object) this;
        if (!BTWAtmos.mod_instance.isLoaded())
            BTWAtmos.mod_instance.onInitCompleted(mc);
    }

    @Inject(method = "runTick", at = @At("TAIL"))
    private void updateInput(CallbackInfo ci) {
        // Handle input
        MAtMod addon = (MAtMod) BTWAtmos.mod_instance.getAddon();
        addon.userControl.onTick();

        // Update tick
        Minecraft mc = (Minecraft) (Object) this;
        boolean inGame = PortUtil.isInGame(mc);
        BTWAtmos.mod_instance.onTick(mc, this.prevFrameTime, inGame, !isGamePaused);
    }
}
