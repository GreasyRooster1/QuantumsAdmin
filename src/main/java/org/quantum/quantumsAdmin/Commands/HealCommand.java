package org.quantum.quantumsAdmin.Commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.PlayerSelector;
import org.quantum.quantumsAdmin.Util.Command.BaseCommand;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;
import org.quantum.quantumsAdmin.Util.Command.CommandUtils;

import java.util.List;

public class HealCommand extends BaseCommand {
    public HealCommand() {
        super("heal");
        arguments = new CommandArgument[]{new PlayerSelector(false)};
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        List<Entity> entities;
        if(args.length<1){
            entities = List.of(((Player)sender));
        }else{
            Entity[] utilResult = CommandUtils.getTargets(sender,args[0]);
            if(utilResult==null){
                return CommandStatus.ERROR;
            }
            entities = List.of(utilResult);
        }

        for(Entity entity : entities){
            if(entity instanceof LivingEntity){
                ((LivingEntity) entity).setHealth(((LivingEntity) entity).getMaxHealth());
            }
        }
        Chat.sendSuccess(sender,"Healed "+entities.size()+" targets");
        return CommandStatus.OK;
    }

    @Override
    public String getArgumentUsage() {
        return "";
    }
}
