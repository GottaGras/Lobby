package net.gottagras;

import org.bukkit.plugin.java.JavaPlugin;

import net.gottagras.features.global.GlobalManager;
import net.gottagras.features.global.GlobalListener;
import net.gottagras.features.protection.ProtectionListener;
import net.gottagras.features.protection.ProtectionManager;
import net.gottagras.utils.WorldUtils;

public class Main extends JavaPlugin {

    private ProtectionManager protectionManager;
    private GlobalManager globalManager;

    @Override
    public void onEnable() {
        // Save default config if not present
        saveDefaultConfig();

        // Set world rules
        new WorldUtils(this).setWorldRules();

        // Initialize ProtectionManager and register ProtectionListener
        this.protectionManager = new ProtectionManager(this);
        getServer().getPluginManager().registerEvents(new ProtectionListener(this.protectionManager), this);

        // Initialize GlobalManager and register GlobalListener
        this.globalManager = new GlobalManager(this);
        getServer().getPluginManager().registerEvents(new GlobalListener(this.globalManager), this);

        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }
}