package net.gottagras.features.selector;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import net.gottagras.utils.BungeeUtils;

public class SelectorListerner implements Listener {

    private SelectorManager selectorManager;

    public SelectorListerner(SelectorManager selectorManager) {
        this.selectorManager = selectorManager;
        this.selectorManager.populateGameSelectorItems();
    }

    // Give selector item on player join
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.getInventory().setItem(selectorManager.getSelectorSlot(),
                selectorManager.getSelectorItem());
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack itemInUse = player.getInventory().getItemInMainHand();
        if (selectorManager.isSelectorItem(itemInUse)) {
            player.openInventory(selectorManager.getSelectorInventory());

            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClickEvent(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        // Check if the clicked item is the selector item
        if (selectorManager.isSelectorItem(clickedItem)) {
            player.openInventory(selectorManager.getSelectorInventory());
        }

        if (selectorManager.isGameSelectorItem(clickedItem)) {
            String server = selectorManager.getServerForItem(clickedItem);
            new BungeeUtils().sendToServer(player, server);
        }
    }
}