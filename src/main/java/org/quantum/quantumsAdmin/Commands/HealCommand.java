package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.BaseCommand;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.CommandStatus;

public class HealCommand extends BaseCommand {
    public HealCommand() {
        super("heal");
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        ((Player)sender).setHealth(((Player)sender).getMaxHealth());
        Chat.sendSuccess(sender,"Healed player");
        return CommandStatus.OK;
    }

    @Override
    public String getArgumentUsage() {
        return "";
    }
}
