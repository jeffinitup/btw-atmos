package com.jeffyjamzhd.btwatmos.shim;

import net.minecraft.src.Minecraft;

public class PortUtil {
    public static void printChat(Object... args)
    {
        if (Minecraft.getMinecraft().thePlayer == null)
            return;

        StringBuilder builder = new StringBuilder();
        for (Object o : args)
        {
            builder.append(o);
        }
        Minecraft.getMinecraft().thePlayer.addChatMessage(builder.toString());
    }

    public static boolean isInGame(Minecraft minecraft) {
        return minecraft.theWorld != null;
    }
}
