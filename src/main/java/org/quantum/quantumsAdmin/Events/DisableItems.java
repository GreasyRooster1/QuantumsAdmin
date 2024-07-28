package org.quantum.quantumsAdmin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class DisableItems {
    public static ArrayList<String> disabledItems = new ArrayList<String>();

    public static void checkDisabledItems(Player player, ItemStack item, PlayerInteractEvent event) {
        if (disabledItems.contains(item.getType().name().toLowerCase())) {
            event.setCancelled(true);
        }
    }
}
