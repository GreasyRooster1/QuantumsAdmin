package org.quantum.quantumsAdmin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;
import org.quantum.quantumsAdmin.AdminTool;
import org.quantum.quantumsAdmin.AdminTools.AdminSword;
import org.quantum.quantumsAdmin.Util.Chat;
import org.quantum.quantumsAdmin.Util.Command.BaseCommand;
import org.quantum.quantumsAdmin.Util.Command.CommandStatus;

import java.util.List;

public class ToolsCommand extends BaseCommand {
    public List<AdminTool> tools = List.of(
            new AdminSword()
    );

    public ToolsCommand() {
        super("admintools");
        playerOnly=true;
    }

    @Override
    public CommandStatus runCommand(@NotNull CommandSender sender, @NotNull String[] args) {
        Inventory inventory = Bukkit.createInventory((InventoryHolder) sender,45);

        for (int i=0;i<tools.size();i++) {
            AdminTool tool = tools.get(i);
            inventory.setItem(getSlot(i),tool.getItem());
        }

        ((Player) sender).openInventory(inventory);
        return CommandStatus.OK;
    }

    private int getSlot(int i) {
        int row = (int) ((Math.floor((float) i/7.0))*2)+1;
        int col = (i%7)+1;
        return row*9+col;
    }

    @Override
    public @NotNull String getDescription() {
        return "Admin tools gui";
    }
}
