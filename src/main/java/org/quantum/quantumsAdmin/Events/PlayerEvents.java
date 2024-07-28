package org.quantum.quantumsAdmin.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static org.quantum.quantumsAdmin.Events.DisableItems.checkDisabledItems;
import static org.quantum.quantumsAdmin.Events.DisableItems.disabledItems;

public class PlayerEvents implements Listener {

    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (item != null) {
                checkDisabledItems(player,item,event);
            }
        }
    }


}
