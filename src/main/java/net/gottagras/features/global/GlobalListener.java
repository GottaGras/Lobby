package net.gottagras.features.global;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.gottagras.utils.PlayerUtils;

public class GlobalListener implements Listener {

    private final GlobalManager globalManager;

    public GlobalListener(GlobalManager globalManager) {
        this.globalManager = globalManager;
    }

    // Handle player join events
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new PlayerUtils().resetPlayer(player);
        String message = globalManager.getJoinMessage(player);
        globalManager.teleportToSpawn(player);
        event.setJoinMessage(message);
    }

    // Handle player quit events
    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String message = globalManager.getLeaveMessage(player);
        event.setQuitMessage(message);
    }
}
