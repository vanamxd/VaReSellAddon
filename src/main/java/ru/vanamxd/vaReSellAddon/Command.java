package ru.vanamxd.vaReSellAddon;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Command implements Listener {
    private final Main plugin;

    public Command(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        String msg = e.getMessage().toLowerCase();
        if (!msg.startsWith("/ah ")) return;

        String[] args = msg.substring(4).split(" ");
        if (args.length == 0) return;

        if (args[0].equals("resell")) {
            e.setCancelled(true); // отменяем только для resell
            plugin.getResellCommand().onCommand(e.getPlayer(), null, "ah", args);
        }
        // Все остальные подкоманды /ah обрабатывает BAuction
    }
}