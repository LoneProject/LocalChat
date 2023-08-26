package org.lone64.localchat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.lone64.localchat.LocalChat;
import org.lone64.localchat.util.adventure.AdventureUtil;

public class MainCmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        if (sender instanceof ConsoleCommandSender) return true;

        Player player = (Player) sender;
        if (args.length == 0) {
            AdventureUtil.playerMessage(player, "{@p} &7올바르지 않는 명령어입니다!");
            return true;
        }

        switch (args[0]) {
            default:
                AdventureUtil.playerMessage(player, "{@p} &7올바르지 않는 명령어입니다!");
                break;
            case "켜기":
                if (LocalChat.getPlayerMap().get(player) != null) {
                    AdventureUtil.playerMessage(player, "{@p} &7이미 지역채팅이 &a활성화&7되어 있습니다!");
                    return true;
                }

                LocalChat.getPlayerMap().put(player, true);
                AdventureUtil.playerMessage(player, "{@p} &e지역채팅&f이 &a활성화&f되었습니다!");
                break;
            case "끄기":
                if (LocalChat.getPlayerMap().get(player) == null) {
                    AdventureUtil.playerMessage(player, "{@p} &7이미 지역채팅이 &c비활성화&7되어 있습니다!");
                    return true;
                }

                LocalChat.getPlayerMap().remove(player);
                AdventureUtil.playerMessage(player, "{@p} &e지역채팅&f이 &c비활성화&f되었습니다!");
                break;
        }
        return false;
    }

}
