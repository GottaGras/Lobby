package net.gottagras.features.protection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import net.gottagras.utils.PlayerUtils;

import org.bukkit.Sound;

public class ProtectionListener implements Listener {

    private final ProtectionManager protectionManager;

    public ProtectionListener(ProtectionManager protectionManager) {
        this.protectionManager = protectionManager;
    }

    // Handle block break events
    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Boolean canBreak = protectionManager.canBreakBlock(player);
        event.setCancelled(!canBreak);

        if (!canBreak) {
            String message = protectionManager.getBreakBlockDeniedMessage();
            player.sendMessage(message);
            player.playSound(player, Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
        }
        return;
    }

    // Handle block place events
    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Boolean canPlace = protectionManager.canPlaceBlock(player);
        event.setCancelled(!canPlace);

        if (!canPlace) {
            String message = protectionManager.getPlaceBlockDeniedMessage();
            player.sendMessage(message);
            player.playSound(player, Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
        }
        return;
    }

    // Handle item drop events
    @EventHandler
    public void onPlayerDropItemEvent(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Boolean canDrop = protectionManager.canDropItem(player);
        event.setCancelled(!canDrop);

        if (!canDrop) {
            String message = protectionManager.getDropItemDeniedMessage();
            player.sendMessage(message);
            player.playSound(player, Sound.BLOCK_ANVIL_PLACE, 1f, 1f);
        }
        return;
    }

    // Handle player join events
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        new PlayerUtils().resetPlayer(player);
        String message = protectionManager.getJoinMessage(player);
        event.setJoinMessage(message);
    }

    // Handle player quit events
    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        String message = protectionManager.getLeaveMessage(player);
        event.setQuitMessage(message);
    }

    // Handle player move events
    @EventHandler
    public void onPlayerMoveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        player.setFoodLevel(20);
        player.setSaturation(20);
    }

    // Handle entity damage events
    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            event.setCancelled(true);
        }
    }
}
