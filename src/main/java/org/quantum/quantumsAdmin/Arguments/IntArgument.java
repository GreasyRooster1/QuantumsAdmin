package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.util.ArrayList;
import java.util.List;

import static org.quantum.quantumsAdmin.Util.Util.isNumeric;

public class IntArgument extends CommandArgument {
    public IntArgument(boolean _required) {
        super(_required);
        usage="number";
    }

    @Override
    public boolean isValid(String arg) {
        return isNumeric(arg);
    }
}
