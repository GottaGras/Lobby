package net.gottagras.utils;

import org.bukkit.ChatColor;

import net.gottagras.Main;

public class ChatUtils {

    public static String getMessage(String confPath) {
        String prefix = Main.getInstance().getConfig().getString("global.prefix");
        String message = Main.getInstance().getConfig().getString(confPath);
        return ChatColor.translateAlternateColorCodes('&', prefix + message);
    }
}
