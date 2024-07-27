package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.EntitySelector;
import org.quantum.quantumsAdmin.Arguments.IntArgument;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;
import org.quantum.quantumsAdmin.Util.Command.EntityCommand;

import java.util.List;

public class IgniteCommand extends EntityCommand {
    public IgniteCommand() {
        super("ignite");
        playerOnly = false;
        arguments = new CommandArgument[]{new EntitySelector(false),new IntArgument(false)};
    }

    @Override
    public CommandStatus preformAction(CommandSender sender, Entity e, String[] args) {
        int ticks = 100;
        if(args.length>1){
            ticks = Integer.parseInt(args[1]);
        }
        e.setFireTicks(ticks);
        return CommandStatus.OK;
    }

    @Override
    public CommandStatus postAction(CommandSender sender, List<Entity> entities, String[] args) {
        Chat.sendSuccess(sender,"Set "+entities.size()+" targets on fire");
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Ignites targets";
    }
}
