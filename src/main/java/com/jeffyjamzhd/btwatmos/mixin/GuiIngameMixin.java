package com.jeffyjamzhd.btwatmos.mixin;

import com.jeffyjamzhd.btwatmos.BTWAtmos;
import eu.ha3.matmos.game.system.MAtMod;
import net.minecraft.src.GuiIngame;
import net.minecraft.src.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class GuiIngameMixin {
    @Inject(method = "renderGameOverlay", at = @At("TAIL"))
    private void renderScroller(float par1, boolean par2, int par3, int par4, CallbackInfo ci) {
        MAtMod addon = (MAtMod) BTWAtmos.MATMOS.getAddon();
        addon.userControl.onFrame(Minecraft.getMinecraft().getTimer().renderPartialTicks);
    }
}
