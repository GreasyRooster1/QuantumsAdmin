package org.quantum.quantumsAdmin.Arguments;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.Util.Command.CommandArgument;

import java.util.ArrayList;
import java.util.List;

public class ItemTypeArgument extends CommandArgument {
    public ItemTypeArgument(boolean _required) {
        super(_required);
        usage = "entity";
    }

    @Override
    public boolean isValid(String arg) {
        for (Material type : Material.values()) {
            if (type.name().equalsIgnoreCase(arg)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> list = new ArrayList<String>();
        for (Material type : Material.values()) {
            list.add(type.name());
        }
        return list;
    }
}
