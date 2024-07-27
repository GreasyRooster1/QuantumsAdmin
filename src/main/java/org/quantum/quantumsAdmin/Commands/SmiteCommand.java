package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;
import org.quantum.quantumsAdmin.Util.Command.EntityCommand;

public class SmiteCommand extends EntityCommand {
    public SmiteCommand() {
        super("smite");
        playerOnly = false;
    }

    @Override
    public CommandStatus preformAction(CommandSender sender, Entity e, String[] args) {
        e.getWorld().strikeLightning(e.getLocation());
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Spawns lightning on targets";
    }
}
