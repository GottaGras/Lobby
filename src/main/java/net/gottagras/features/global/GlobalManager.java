package net.gottagras.features.global;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import net.gottagras.Main;
import net.gottagras.utils.ChatUtils;

public class GlobalManager {

    private Main plugin;

    public GlobalManager(Main main) {
        this.plugin = main;
    }

    // Get the join message for a player
    public String getJoinMessage(Player player) {
        String template = new ChatUtils(plugin).getMessage("global.join-messages.welcome");
        return template.replace("{player}", player.getName());
    }

    // Get the leave message for a player
    public String getLeaveMessage(Player player) {
        String template = new ChatUtils(plugin).getMessage("global.join-messages.leave");
        return template.replace("{player}", player.getName());
    }

    // Teleport player to spawn location
    public void teleportToSpawn(Player player) {
        int x = plugin.getConfig().getInt("global.spawn.x");
        int y = plugin.getConfig().getInt("global.spawn.y");
        int z = plugin.getConfig().getInt("global.spawn.z");
        float yaw = (float) plugin.getConfig().getDouble("global.spawn.yaw");
        float pitch = (float) plugin.getConfig().getDouble("global.spawn.pitch");
        String worldName = plugin.getConfig().getString("global.spawn.world");

        Location spawnLocation = new Location(
                plugin.getServer().getWorld(worldName),
                x,
                y,
                z,
                yaw,
                pitch);
        player.teleport(spawnLocation);
    }
}
