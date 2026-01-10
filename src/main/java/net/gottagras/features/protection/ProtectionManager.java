package net.gottagras.features.protection;

import org.bukkit.entity.Player;

import net.gottagras.Main;
import net.md_5.bungee.api.ChatColor;

public class ProtectionManager {
    private final Main plugin;

    public ProtectionManager(Main main) {
        this.plugin = main;
    }

    public boolean canBreakBlock(Player player) {
        if (player.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    public String getBreakBlockDeniedMessage() {
        String prefix = plugin.getConfig().getString("global.prefix");
        String message = plugin.getConfig().getString("protection.messages.deny-break");
        return ChatColor.translateAlternateColorCodes('&', prefix + message);
    }

    public Boolean canPlaceBlock(Player player) {
        if (player.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    public String getPlaceBlockDeniedMessage() {
        String prefix = plugin.getConfig().getString("global.prefix");
        String message = plugin.getConfig().getString("protection.messages.deny-place");
        return ChatColor.translateAlternateColorCodes('&', prefix + message);
    }
}
