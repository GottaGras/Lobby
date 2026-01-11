package net.gottagras.features.protection;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import static org.bukkit.Sound.*;

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
            player.playSound(player, BLOCK_ANVIL_PLACE, 1f, 1f);
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
            player.playSound(player, BLOCK_ANVIL_PLACE, 1f, 1f);
        }
        return;
    }

    @EventHandler
    public void on(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        Boolean canDrop = protectionManager.canDropItem(player);
        event.setCancelled(!canDrop);

        if (!canDrop) {
            String message = protectionManager.getDropItemDeniedMessage();
            player.sendMessage(message);
            player.playSound(player, BLOCK_ANVIL_PLACE, 1f, 1f);
        }
        return;
    }

}
