package net.fabricmc.example.mixin;

import btw.community.example.BTWAtmos;
import net.minecraft.src.Minecraft;
import net.minecraft.src.WorldClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldClient.class)
public class WorldClientMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void updateTick(CallbackInfo ci) {
    }
}
