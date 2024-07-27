package org.quantum.quantumsAdmin.Util.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CommandArgument {
    public boolean required = false;
    public String usage;

    public CommandArgument(boolean _required){
        required = _required;
    }

    public boolean isValid(String arg){
        return false;
    }

    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args){
        return List.of();
    }
}
