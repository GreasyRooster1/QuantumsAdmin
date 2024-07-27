package org.quantum.quantumsAdmin.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.BoolArgument;
import org.quantum.quantumsAdmin.Arguments.EntitySelector;
import org.quantum.quantumsAdmin.Arguments.PlayerSelector;
import org.quantum.quantumsAdmin.Arguments.SinglePlayerSelector;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;
import org.quantum.quantumsAdmin.Util.Command.EntityCommand;

import java.util.List;

public class FlyCommand extends EntityCommand {
    public FlyCommand() {
        super("fly");
        playerOnly = false;
        arguments = new CommandArgument[]{new PlayerSelector(false),new BoolArgument(false)};
    }

    @Override
    public CommandStatus preformAction(CommandSender sender, Entity e, String[] args) {
        if(e instanceof Player) {
            Player player = (Player) e;
            if(player.getGameMode()== GameMode.CREATIVE){
                return CommandStatus.OK;
            }
            if(args.length == 2) {
                player.setAllowFlight(args[1].equalsIgnoreCase("on"));
            }else{
                player.setAllowFlight(!player.getAllowFlight());
            }
        }
        return CommandStatus.OK;
    }

    @Override
    public CommandStatus postAction(CommandSender sender, List<Entity> entities, String[] args) {
        if(args.length==2) {
            if(args[1].equalsIgnoreCase("on")){
                Chat.send(sender,"<green><bold>Enabled</bold> flight for "+entities.size()+" targets</green>");
            }else{
                Chat.send(sender,"<red>Disabled flight for "+entities.size()+" targets</red>");
            }
        }else{
            Chat.send(sender,"<green>Toggled flight for "+entities.size()+" targets</green>");
        }
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Enables or disables flight for targets";
    }
}
