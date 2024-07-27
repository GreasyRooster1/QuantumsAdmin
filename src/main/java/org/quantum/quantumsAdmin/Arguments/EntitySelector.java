package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.util.ArrayList;
import java.util.List;

public class EntitySelector extends CommandArgument {
    public EntitySelector(boolean _required) {
        super(_required);
        usage = "target";
    }

    @Override
    public boolean isValid(String arg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getName().equals(arg)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<String>();
        for (Player p : Bukkit.getOnlinePlayers()) {
            list.add(p.getName());
        }
        return list;
    }
}
