package net.fabricmc.example.mixin;

import btw.community.example.BTWAtmos;
import net.minecraft.src.Minecraft;
import net.minecraft.src.Timer;
import net.minecraft.src.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Shadow private Timer timer;

    @Inject(method = "startGame", at = @At("TAIL"))
    private void initMod(CallbackInfo ci) {
    }

    @Inject(method = "runGameLoop", at = @At("TAIL"))
    private void updateFrame(CallbackInfo ci) {
        Minecraft mc = Minecraft.getMinecraft();
        BTWAtmos.mod_instance.onTick(mc, this.timer.renderPartialTicks, mc.theWorld != null, mc.theWorld != null);
    }

    @Inject(method = "loadWorld(Lnet/minecraft/src/WorldClient;Ljava/lang/String;)V", at = @At("TAIL"))
    private void loadMAtmos(WorldClient par1WorldClient, String par2Str, CallbackInfo ci) {
        BTWAtmos.mod_instance.onInitCompleted(Minecraft.getMinecraft());
    }
}
