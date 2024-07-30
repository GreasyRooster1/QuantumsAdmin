package org.quantum.quantumsAdmin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.quantum.quantumsAdmin.AdminTool;

import java.util.ArrayList;

import static org.quantum.quantumsAdmin.Commands.ToolsCommand.adminTools;

public class AdminToolEvents {

    public static void checkAdminTools(Player player, ItemStack item, PlayerInteractEvent event) {
        if(!player.isOp()){
            return;
        }
        for(AdminTool tool : adminTools){
            if(item.getItemMeta().getCustomModelData()==tool.getId()){
                tool.onRightClick(player,event);
            }
        }
    }
}
