package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.EntitySelector;
import org.quantum.quantumsAdmin.Arguments.IntArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;
import org.quantum.quantumsAdmin.Util.Command.EntityCommand;

public class ExplodeCommand extends EntityCommand {
    public ExplodeCommand() {
        super("explode");
        arguments = new CommandArgument[]{new EntitySelector(false),new IntArgument(false)};
        playerOnly = false;
    }

    @Override
    public CommandStatus preformAction(CommandSender sender, Entity e, String[] args) {
        float power = 5;
        if(args.length>1){
            power = (float)Integer.parseInt(args[1]);
        }
        e.getWorld().createExplosion(e.getLocation(),power);
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Explodes targets";
    }
}
