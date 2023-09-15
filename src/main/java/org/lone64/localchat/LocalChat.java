package org.lone64.localchat;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.lone64.localchat.command.MainCmd;
import org.lone64.localchat.command.MainTab;
import org.lone64.localchat.listener.PlayerListener;
import org.lone64.localchat.util.file.Config;

import java.util.HashMap;
import java.util.Map;

public final class LocalChat extends JavaPlugin {

    private static LocalChat instance;
    private static String prefix;
    private static Map<Player, Boolean> playerMap;

    @Override
    public void onLoad() {
        instance = this;
        prefix = "[지역채팅]";
        playerMap = new HashMap<>();
    }

    @Override
    public void onEnable() {
        if (!new Config("config.yml").isExists())
            saveResource("config.yml", false);

        this.getCommand("지역채팅").setExecutor(new MainCmd());
        this.getCommand("지역채팅").setTabCompleter(new MainTab());
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {

    }

    public static LocalChat getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static Map<Player, Boolean> getPlayerMap() {
        return playerMap;
    }

}
