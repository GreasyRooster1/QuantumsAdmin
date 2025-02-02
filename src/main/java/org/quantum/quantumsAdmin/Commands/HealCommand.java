package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.*;
import org.quantum.quantumsAdmin.Util.Chat;

import java.util.List;

public class HealCommand extends EntityCommand {
    public HealCommand() {
        super("heal");
        playerOnly = false;
    }

    @Override
    public CommandStatus preformAction(CommandSender sender, Entity e, String[] args) {
        if(e instanceof LivingEntity) {
            ((LivingEntity) e).setHealth(((LivingEntity) e).getMaxHealth());
        }
        return CommandStatus.OK;
    }

    @Override
    public CommandStatus postAction(CommandSender sender, List<Entity> entities, String[] args) {
        Chat.sendSuccess(sender,"Healed "+entities.size()+" targets");
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Heals targets";
    }
}
