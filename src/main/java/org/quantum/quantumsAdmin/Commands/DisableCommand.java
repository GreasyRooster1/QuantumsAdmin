package org.quantum.quantumsAdmin.Commands;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Arguments.ChoiceArgument;
import org.quantum.quantumsAdmin.Arguments.ItemTypeArgument;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.BaseCommand;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;

import java.util.ArrayList;

import static org.quantum.quantumsAdmin.Events.DisableItems.disabledItems;

public class DisableCommand extends BaseCommand {
    public DisableCommand() {
        super("disable");
        minArguments = 1;
        playerOnly = false;

        ArrayList<String> choices = new ArrayList<>();
        choices.add("add");
        choices.add("remove");
        choices.add("view");

        arguments = new CommandArgument[]{
                new ChoiceArgument(true).setChoices(choices),
                new ItemTypeArgument(false),
        };
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        if(args.length==2) {
            if (args[0].equalsIgnoreCase("add")) {
                disabledItems.add(args[1]);
                Chat.sendSuccess(sender,"Added <light_purple>"+args[1]+"</light_purple> to disabled items!");
            }
            if (args[0].equalsIgnoreCase("remove")) {
                if(disabledItems.remove(args[1])) {
                    Chat.sendSuccess(sender, "Removed <light_purple>" + args[1] + "</light_purple> from disabled items!");
                }else{
                    Chat.sendError(sender,"That item was not in the list!");
                }
            }
        }else{
            if (args[0].equalsIgnoreCase("view")) {
                String out = "<green>Items currently disabled:</green>\n";
                for (String item : disabledItems) {
                    out += "<white>[</white><light_purple>"+item+"<white>], </white></light_purple>";
                }
                Chat.send(sender,out);
            }
        }
        System.out.println(disabledItems);
        return CommandStatus.OK;
    }

    @Override
    public @NotNull String getDescription() {
        return "Disable usage of specific items";
    }
}
