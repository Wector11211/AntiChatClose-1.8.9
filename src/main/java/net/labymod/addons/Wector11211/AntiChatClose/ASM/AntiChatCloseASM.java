package net.labymod.addons.Wector11211.AntiChatClose.ASM;

import net.labymod.addons.Wector11211.AntiChatClose.AntiChatCloseAddon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

public class AntiChatCloseASM {
    public static boolean preventChatClosing(){
            if (AntiChatCloseAddon.getInstance() == null || !AntiChatCloseAddon.getInstance().isEnabled()) return false;
            return (Minecraft.getMinecraft().currentScreen instanceof GuiChat);
    }
}
