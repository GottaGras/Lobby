package net.gottagras.utils;

import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import net.gottagras.Main;

public class BungeeUtils {
    public static void sendToServer(Player player, String serverName) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();

        out.writeUTF("Connect");
        out.writeUTF(serverName);

        player.sendPluginMessage(Main.getInstance(), "BungeeCord", out.toByteArray());

        player.sendMessage("§aYou are being transferred to §e" + serverName + "§a...");
    }
}
