package net.gottagras.features.protection;

import org.bukkit.entity.Player;

import net.gottagras.Main;
import net.gottagras.utils.Chat;

public class ProtectionManager {
    private final Main plugin;

    public ProtectionManager(Main main) {
        this.plugin = main;
    }

    // Check if a player can break blocks
    public boolean canBreakBlock(Player player) {
        if (player.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    // Get the message to display when block breaking is denied
    public String getBreakBlockDeniedMessage() {
        return new Chat(plugin).getMessage("protection.messages.deny-break");
    }

    // Check if a player can place blocks
    public Boolean canPlaceBlock(Player player) {
        if (player.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    // Get the message to display when block placing is denied
    public String getPlaceBlockDeniedMessage() {
        return new Chat(plugin).getMessage("protection.messages.deny-place");
    }

    public Boolean canDropItem(Player player) {
        if (player.getGameMode() != org.bukkit.GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    public String getDropItemDeniedMessage() {
        return new Chat(plugin).getMessage("protection.messages.deny-drop");
    }
}
