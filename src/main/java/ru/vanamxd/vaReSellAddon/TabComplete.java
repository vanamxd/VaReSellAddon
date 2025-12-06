package ru.vanamxd.vaReSellAddon;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements Listener {

    @EventHandler
    public void onTabComplete(PlayerChatTabCompleteEvent e) {
        String msg = e.getChatMessage().toLowerCase();

        if (!msg.startsWith("/ah ")) return;

        String[] args = msg.substring(4).split(" ");
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            if ("resell".startsWith(args[0])) completions.add("resell");
        }

        e.getTabCompletions().addAll(completions);
    }
}