package net.gottagras.utils;

import org.bukkit.entity.Player;

public class PlayerUtils {

    public static void resetPlayer(Player player) {
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.setHealth(20);
        player.setExp(0);
        player.setLevel(0);
        player.setGameMode(org.bukkit.GameMode.SURVIVAL);
        player.getInventory().clear();
        player.getActivePotionEffects().forEach(effect -> player.removePotionEffect(effect.getType()));
    }

}
