package org.quantum.quantumsAdmin.Util.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quantum.quantumsAdmin.QuantumsAdmin;
import org.quantum.quantumsAdmin.Util.Chat;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand extends BukkitCommand implements TabCompleter {
    public String name;

    public int minArguments = 0;
    public CommandArgument[] arguments = {};

    public boolean playerOnly = true;
    public boolean isOp = true;

    public List<String> delayedPlayers = null;
    public int delay = 0;

    public BaseCommand(String command){
        super(command);
        this.name=command;
    }

    public void register(){
        QuantumsAdmin plugin = QuantumsAdmin.getInstance();
        plugin.getServer().getCommandMap().register(name,this);
    }

    public BaseCommand enableDelay(int _delay){
        delay = _delay;
        delayedPlayers = new ArrayList<>();
        return this;
    }

    public BaseCommand setOp(boolean op){
        isOp = op;
        return this;
    }

    public void removeDelay(Player player){
        this.delayedPlayers.remove(player.getName());
    }

    public void sendUsage(CommandSender sender){
        Chat.send(sender,getUsage());
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String[] args) {
        if(args.length<minArguments||args.length>arguments.length){
            sendUsage(sender);
            Chat.sendError(sender,"Invalid number of arguments");
            return true;
        }

        if(playerOnly && !(sender instanceof Player)){
            Chat.sendError(sender,"Only players can use this command!");
            return true;
        }

        String permission = getPermission();
        if(permission!=null&& !sender.hasPermission(permission)){
            Chat.sendError(sender,"You do not have the required permissions");
            return true;
        }

        if(isOp&&!sender.isOp()){
            Chat.sendError(sender,"You do not have the required permissions");
            return true;
        }

        if(delayedPlayers!=null&&sender instanceof Player){
            Player player = (Player)sender;
            if(delayedPlayers.contains(player.getName())) {
                Chat.sendError(player,"Please wait before using this command again");
                return true;
            }
            delayedPlayers.add(player.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(QuantumsAdmin.getInstance(),()->{
                delayedPlayers.remove(player.getName());
            }, 20L *delay);
        }

        if(runCommand(sender,args)!=CommandStatus.OK){
            sendUsage(sender);
        }

        return false;
    }

    public abstract CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args);

    public abstract String getArgumentUsage();

    public String getUsage(){
        return "/"+name+" "+getArgumentUsage();
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(args.length<arguments.length){
            return List.of();
        }
        return arguments[args.length-1].onTabComplete(commandSender,command,label,args);
    }
}
