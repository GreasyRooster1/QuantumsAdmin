package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ChoiceArgument extends CommandArgument {
    private ArrayList<String> choices = new ArrayList<>();
    public ChoiceArgument(boolean _required) {
        super(_required);
        usage="on | off";
    }

    @Override
    public boolean isValid(String arg) {
        return choices.contains(arg);
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return choices;
    }

    public ChoiceArgument setChoices(ArrayList<String> _choices) {
        choices = _choices;
        usage = String.join(" | ", choices);
        return this;
    }
}
