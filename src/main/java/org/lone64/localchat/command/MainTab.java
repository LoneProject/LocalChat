package org.lone64.localchat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTab implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String arg, @NotNull String[] args) {
        List<String> tab = new ArrayList<>();
        if (sender instanceof Player) {
            if (args.length == 1) {
                tab.addAll(Arrays.asList("켜기", "끄기"));
            }
        }
        return tab;
    }

}
