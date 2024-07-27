package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.util.ArrayList;
import java.util.List;

public class PlayerSelector extends CommandArgument {
    @Override
    public boolean isValid(String arg) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getName().equals(arg)) {
                return true;
            }
        }
        return false;
    }
}
