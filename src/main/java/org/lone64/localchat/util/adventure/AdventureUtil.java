package org.lone64.localchat.util.adventure;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.lone64.localchat.LocalChat;
import org.lone64.localchat.util.Util;
import org.lone64.localchat.util.color.builders.GradientTextBuilder;

import java.util.ArrayList;

public class AdventureUtil {

    public static String getPrefix() {
        return new GradientTextBuilder().text(LocalChat.getPrefix())
                .addColor("#00ffff")
                .addColor("#6a5acd")
                .blur(0.12)
                .build()
                .getJsonText();
    }

    public static void playerLocalMessage(Player player, String s) {
        if (s == null) return;
        String name = getPrefix();
        ArrayList<Entity> entities = new ArrayList<>(player.getWorld().getNearbyEntities(player.getLocation(), 5, 5, 5));
        for (Entity entity : entities) {
            if (!(entity instanceof Player)) continue;
            Player p = (Player) entity;
            AdventureUtil.playerMessage(p, "{@p} &f" + player.getName() + ": " + s);
        }
    }

    public static void broadcastMessage(String s) {
        if (s == null) return;
        String name = getPrefix();
        Bukkit.broadcastMessage(Util.replaceLegacyColor(s.replace("{@p}", name)));
    }

    public static void consoleMessage(String s) {
        if (s == null) return;
        String name = getPrefix();
        Bukkit.getConsoleSender().sendMessage(Util.replaceLegacyColor(s.replace("{@p}", name)));
    }

    public static void playerMessage(Player player, String s) {
        if (s == null) return;
        String name = getPrefix();
        player.sendMessage(Util.replaceLegacyColor(s.replace("{@p}", name)));
    }

    public static void playerSound(Player player, Sound sound) {
        if (sound == null) return;
        player.playSound(player.getLocation(), sound, 1, 2);
    }

}
