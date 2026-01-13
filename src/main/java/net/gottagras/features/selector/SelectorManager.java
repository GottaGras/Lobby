package net.gottagras.features.selector;

import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.gottagras.Main;
import net.gottagras.utils.ItemUtils;
import net.md_5.bungee.api.ChatColor;

public class SelectorManager {

    private Main plugin;

    private List<GameSelectorItem> gameSelectorItems = new java.util.ArrayList<>();

    public SelectorManager(Main main) {
        this.plugin = main;
    }

    // Build item with name, lore, and material
    private ItemStack itemBuilder(String name, List<String> lore, Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    // Get the selector item from config
    public ItemStack getSelectorItem() {
        String name = plugin.getConfig().getString("selector.item.name");
        name = ChatColor.translateAlternateColorCodes('&', name);

        List<String> lore = plugin.getConfig().getStringList("selector.item.lore");
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i, ChatColor.translateAlternateColorCodes('&', lore.get(i)));
        }

        Material material = Material.getMaterial(plugin.getConfig().getString("selector.item.material"));

        return itemBuilder(name, lore, material);
    }

    // Get the selector slot from config
    public int getSelectorSlot() {
        return plugin.getConfig().getInt("selector.item.slot");
    }

    // Create and return the selector inventory
    public Inventory getSelectorInventory() {
        String name = plugin.getConfig().getString("selector.item.name");
        name = ChatColor.translateAlternateColorCodes('&', name);
        Inventory inventory = Bukkit.createInventory(null, 9, name);

        for (GameSelectorItem gameItem : gameSelectorItems) {
            inventory.setItem(gameItem.slot, gameItem.item);
        }

        return inventory;
    }

    // Populate game selector items from config
    public void populateGameSelectorItems() {
        gameSelectorItems.clear();
        List<Map<?, ?>> games = plugin.getConfig().getMapList("selector.games");
        for (Map<?, ?> gameConfig : games) {
            try {
                String gameName = (String) gameConfig.get("name");
                gameName = ChatColor.translateAlternateColorCodes('&', gameName);

                @SuppressWarnings("unchecked")
                List<String> gameLore = (List<String>) gameConfig.get("lore");
                for (int i = 0; i < gameLore.size(); i++) {
                    gameLore.set(i, ChatColor.translateAlternateColorCodes('&', gameLore.get(i)));
                }

                Material gameMaterial = Material.getMaterial((String) gameConfig.get("icon"));
                int gameSlot = (int) gameConfig.get("slot");

                ItemStack gameItem = itemBuilder(gameName, gameLore, gameMaterial);

                String server = (String) gameConfig.get("server");

                GameSelectorItem gameSelectorItem = new GameSelectorItem(gameItem, server, gameSlot);

                gameSelectorItems.add(gameSelectorItem);
                plugin.getLogger().info("Loaded game selector item: " + gameName);

            } catch (Exception e) {
                plugin.getLogger().warning("Error loading game selector item: " + e.getMessage());
            }
        }
    }

    // Check if the item is the selector item
    public boolean isSelectorItem(ItemStack itemInUse) {
        ItemStack selectorItem = getSelectorItem();
        return ItemUtils.isSameItem(itemInUse, selectorItem);
    }

    // Check if the clicked item is a game selector item
    public boolean isGameSelectorItem(ItemStack clickedItem) {
        for (GameSelectorItem selectorItem : gameSelectorItems) {
            if (ItemUtils.isSameItem(clickedItem, selectorItem.getItem())) {
                return true;
            }
        }
        return false;
    }

    // Get the server name for the clicked item
    public String getServerForItem(ItemStack clickedItem) {
        for (GameSelectorItem selectorItem : gameSelectorItems) {
            if (ItemUtils.isSameItem(clickedItem, selectorItem.getItem())) {
                return selectorItem.getServer();
            }
        }
        return null;
    }
}
