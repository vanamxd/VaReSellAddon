package ru.vanamxd.vaReSellAddon;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.by1337.blib.command.argument.ArgumentMap;
import org.by1337.blib.command.Command;

public class ResellCmd extends Command<CommandSender> {

    private final VaReSellAddon resellAddon;

    public ResellCmd(VaReSellAddon resellAddon) {
        super("resell");
        this.resellAddon = resellAddon;
        executor(this::execute);
    }

    private void execute(CommandSender sender, ArgumentMap<String, Object> args) {
        if (!(sender instanceof Player)) return;
        String label = "resell";
        String[] rawArgs = new String[0];
        resellAddon.onCommand(sender, null, label, rawArgs);
    }
}