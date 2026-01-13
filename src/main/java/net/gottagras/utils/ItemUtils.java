package net.gottagras.utils;

import org.bukkit.inventory.ItemStack;

public class ItemUtils {
    public static boolean isSameItem(ItemStack item1, ItemStack item2) {
        if (item1 == null || item2 == null) {
            return false;
        }
        if (item1.getType() != item2.getType()) {
            return false;
        }
        if (item1.hasItemMeta() != item2.hasItemMeta()) {
            return false;
        }
        if (item1.hasItemMeta()) {
            if (!item1.getItemMeta().equals(item2.getItemMeta())) {
                return false;
            }
        }
        return true;
    }
}
