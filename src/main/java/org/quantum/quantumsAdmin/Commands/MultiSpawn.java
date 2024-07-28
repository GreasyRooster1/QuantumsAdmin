package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.EntitySelector;
import org.quantum.quantumsAdmin.Arguments.EntityTypeArgument;
import org.quantum.quantumsAdmin.Arguments.IntArgument;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.BaseCommand;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;

public class MultiSpawn extends BaseCommand {
    public MultiSpawn() {
        super("multispawn");
        minArguments = 2;
        playerOnly = true;
        arguments = new CommandArgument[]{new EntityTypeArgument(true),new IntArgument(true)};
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        for (int i = 0; i < Integer.parseInt(args[1]); i++) {
            ((Player)sender).getWorld().spawnEntity(((Player)sender).getLocation(), getEntityByName(args[0]));
        }
        return CommandStatus.OK;
    }

    public EntityType getEntityByName(String name) {
        for (EntityType type : EntityType.values()) {
            if(type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public @NotNull String getDescription() {
        return "Test command";
    }
}