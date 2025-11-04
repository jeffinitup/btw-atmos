package net.fabricmc.example.reimpl;

import net.minecraft.src.Minecraft;

public class Util {
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
}
