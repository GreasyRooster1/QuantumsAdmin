package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.util.List;

import static org.quantum.quantumsAdmin.Util.Util.isNumeric;

public class BoolArgument extends CommandArgument {
    public BoolArgument(boolean _required) {
        super(_required);
        usage="on | off";
    }

    @Override
    public boolean isValid(String arg) {
        return arg.equals("on") || arg.equals("off");
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return List.of("on", "off");
    }
}
