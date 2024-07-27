package org.quantum.quantumsAdmin.Util.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quantum.quantumsAdmin.Arguments.PlayerSelector;
import org.quantum.quantumsAdmin.Util.Chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class EntityCommand extends BaseCommand {
    public CommandArgument[] additionalArguments;
    public EntityCommand(String command) {
        super(command);
        arguments = new CommandArgument[]{new PlayerSelector(false)};
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        ArrayList<Entity> entities = new ArrayList<>();
        if(args.length<1){
            entities.add((Player)sender);
        }else{
            Entity[] utilResult = CommandUtils.getTargets(sender,args[0]);
            if(utilResult==null){
                return CommandStatus.ERROR;
            }
            for(Entity entity : utilResult){
                if(entity==null){
                    continue;
                }
                entities.add(entity);
            }
        }
        if(preAction(sender,entities,args)==CommandStatus.ERROR){
            return CommandStatus.ERROR;
        }
        for(Entity entity : entities){
            CommandStatus output = preformAction(sender,entity,args);
            if(output==CommandStatus.ERROR){
                return CommandStatus.ERROR;
            }
        }
        return postAction(sender,entities,args);
    }

    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<CommandArgument> commandArguments = new ArrayList<>(List.of());
        Collections.addAll(commandArguments, arguments);
        Collections.addAll(commandArguments, additionalArguments);
        if(args.length<commandArguments.size()){
            return List.of();
        }
        return commandArguments.get(args.length - 1).onTabComplete(commandSender,command,label,args);
    }

    public CommandStatus preAction(CommandSender sender, List<Entity> entities, String[] args) {
        return CommandStatus.OK;
    }

    public abstract CommandStatus preformAction(CommandSender sender,Entity e,String[] args);

    public CommandStatus postAction(CommandSender sender, List<Entity> entities, String[] args) {
        return CommandStatus.OK;
    }
}
