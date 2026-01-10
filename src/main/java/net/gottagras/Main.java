package net.gottagras;

import org.bukkit.plugin.java.JavaPlugin;

import net.gottagras.features.protection.ProtectionListener;
import net.gottagras.features.protection.ProtectionManager;

public class Main extends JavaPlugin {

    private ProtectionManager protectionManager;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Initialize ProtectionManager and register ProtectionListener
        this.protectionManager = new ProtectionManager(this);
        getServer().getPluginManager().registerEvents(new ProtectionListener(this.protectionManager), this);

        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }
}