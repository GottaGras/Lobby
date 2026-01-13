package net.gottagras;

import org.bukkit.plugin.java.JavaPlugin;

import net.gottagras.features.global.GlobalManager;
import net.gottagras.features.global.GlobalListener;
import net.gottagras.features.protection.ProtectionListener;
import net.gottagras.features.protection.ProtectionManager;
import net.gottagras.features.selector.SelectorManager;
import net.gottagras.features.selector.SelectorListerner;
import net.gottagras.utils.WorldUtils;

public class Main extends JavaPlugin {

    private static Main instance;

    private ProtectionManager protectionManager;
    private GlobalManager globalManager;
    private SelectorManager selectorManager;

    @Override
    public void onEnable() {
        // Set the static instance
        instance = this;

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

        // Initialize SelectorManager and register SelectorListener
        this.selectorManager = new SelectorManager(this);
        getServer().getPluginManager().registerEvents(new SelectorListerner(this.selectorManager), this);

        // Register BungeeCord plugin channel
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin disabled!");
    }

    public static Main getInstance() {
        return instance;
    }
}