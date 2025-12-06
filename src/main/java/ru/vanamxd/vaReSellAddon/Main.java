package ru.vanamxd.vaReSellAddon;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main instance;
    private VaReSellAddon resellCommand;

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("BAuction") == null) {
            getServer().getLogger().severe("Не найден плагин BAuction");
            this.setEnabled(false);
            return;
        }
        instance = this;
        saveDefaultConfig();
        resellCommand = new VaReSellAddon(this);
        getServer().getPluginManager().registerEvents(new Command(this), this);

        getServer().getPluginManager().registerEvents(new TabComplete(), this);
    }

    public static Main getInstance() {
        return instance;
    }

    public VaReSellAddon getResellCommand() {
        return resellCommand;
    }
}