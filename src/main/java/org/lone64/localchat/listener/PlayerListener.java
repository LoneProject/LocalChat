package org.lone64.localchat.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.lone64.localchat.LocalChat;
import org.lone64.localchat.util.Util;
import org.lone64.localchat.util.adventure.AdventureUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        if (LocalChat.getPlayerMap().get(event.getPlayer()) == null) return;

        int radius = LocalChat.getChatRadius();
        List<Player> playerList = new ArrayList<>(List.of(event.getPlayer()));
        for (Entity entity : event.getPlayer().getWorld().getNearbyEntities(event.getPlayer().getLocation(), radius, radius, radius)) {
            if (!(entity instanceof Player)) continue;
            playerList.add((Player) entity);
        }

        event.getRecipients().clear();
        event.getRecipients().addAll(playerList);
        event.setFormat(Util.replaceLegacyColor(AdventureUtil.getPrefix() + " &f"
                + event.getPlayer().getName() + ": " + event.getMessage()));
    }

}
