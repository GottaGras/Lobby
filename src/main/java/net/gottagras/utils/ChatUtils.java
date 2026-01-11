package net.gottagras.utils;

import org.bukkit.ChatColor;

import net.gottagras.Main;

public class ChatUtils {

    private Main plugin;

    public ChatUtils(Main main) {
        this.plugin = main;
    }

    public String getMessage(String confPath) {
        String prefix = plugin.getConfig().getString("global.prefix");
        String message = plugin.getConfig().getString(confPath);
        return ChatColor.translateAlternateColorCodes('&', prefix + message);
    }
}
