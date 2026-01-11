package net.gottagras.utils;

import org.bukkit.Difficulty;
import org.bukkit.GameRule;

import net.gottagras.Main;

public class WorldUtils {

    private Main plugin;

    public WorldUtils(Main main) {
        this.plugin = main;
    }

    public void setWorldRules() {
        plugin.getServer().getWorlds().forEach(world -> {
            world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
            world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
            world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
            world.setThundering(false);
            world.setStorm(false);
            world.setWeatherDuration(1000000);
            world.setClearWeatherDuration(1000000);
            world.setDifficulty(Difficulty.NORMAL);
            world.setTime(6000); // Set time to noon
        });
    }
}
