package net.gottagras.features.selector;

import org.bukkit.inventory.ItemStack;

public class GameSelectorItem {
    private ItemStack item;
    private String server;
    private int slot;

    public GameSelectorItem(ItemStack item, String server, int slot) {
        this.item = item;
        this.server = server;
        this.slot = slot;
    }

    public ItemStack getItem() {
        return item;
    }

    public String getServer() {
        return server;
    }

    public int getSlot() {
        return slot;
    }
}
