package net.gottagras.features.protection;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import net.gottagras.Main;
import net.gottagras.utils.ChatUtils;

public class ProtectionManager {
    private final Main plugin;

    public ProtectionManager(Main main) {
        this.plugin = main;
    }

    // Check if a player can break blocks
    public boolean canBreakBlock(Player player) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    // Get the message to display when block breaking is denied
    public String getBreakBlockDeniedMessage() {
        return new ChatUtils(plugin).getMessage("protection.messages.deny-break");
    }

    // Check if a player can place blocks
    public Boolean canPlaceBlock(Player player) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    // Get the message to display when block placing is denied
    public String getPlaceBlockDeniedMessage() {
        return new ChatUtils(plugin).getMessage("protection.messages.deny-place");
    }

    // Check if a player can drop items
    public Boolean canDropItem(Player player) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    // Get the message to display when item dropping is denied
    public String getDropItemDeniedMessage() {
        return new ChatUtils(plugin).getMessage("protection.messages.deny-drop");
    }

    // Check if a player can pick up items
    public Boolean canPickupItem(Player player) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            return false;
        }
        return true;
    }

    public Boolean canInteract(Player player) {
        if (player.getGameMode() != GameMode.CREATIVE) {
            return false;
        }
        return true;
    }
}
