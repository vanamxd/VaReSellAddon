package ru.vanamxd.vaReSellAddon;

import org.bukkit.command.CommandSender;
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

        org.by1337.blib.command.Command<CommandSender> Command =
                ((org.by1337.bauction.Main) getServer().getPluginManager().getPlugin("BAuction")).getCommand();
        Command.addSubCommand(new ResellCmd(resellCommand));
    }

    public static Main getInstance() {
        return instance;
    }

    public VaReSellAddon getResellCommand() {
        return resellCommand;
    }
}