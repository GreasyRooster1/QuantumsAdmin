package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.BaseCommand;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.CommandStatus;

public class TestCommand extends BaseCommand {
    public TestCommand() {
        super("qatest");
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        Chat.sendSuccess(sender,"Plugin appears to be loaded!");
        return CommandStatus.OK;
    }

    @Override
    public String getArgumentUsage() {
        return "";
    }
}
