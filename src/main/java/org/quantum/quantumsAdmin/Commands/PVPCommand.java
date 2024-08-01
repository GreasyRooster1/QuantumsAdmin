package org.quantum.quantumsAdmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.BoolArgument;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.BaseCommand;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;

public class PVPCommand extends BaseCommand {
    public PVPCommand() {
        super("pvp");
        arguments = new CommandArgument[] {new BoolArgument(false)};
        playerOnly = true;
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        World world = ((Player)sender).getWorld();
        if(args.length == 0) {
            world.setPVP(!world.getPVP());
        }else{
            world.setPVP(args[0].equals("on"));
        }
        if(world.getPVP()) {
            Chat.sendSuccess(sender, "PVP is now enabled");
        }else{
            Chat.sendSuccess(sender, "PVP is now disabled");
        }
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Test command";
    }
}
