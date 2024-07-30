package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.quantum.quantumsAdmin.AdminTool;

import static org.quantum.quantumsAdmin.Util.Util.getTarget;
import static org.quantum.quantumsAdmin.Util.Util.getTargetEntity;

public class AdminSword extends AdminTool {

    @Override
    public String getName() {
        return "Admin Sword";
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public Material getItemMaterial() {
        return Material.STONE_SWORD;
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        Entity target = getTargetEntity(player);
        if(target == null) {
            return;
        }
        if(target instanceof LivingEntity) {
            ((LivingEntity) target).damage(99999,player);
        }else{
            target.remove();
        }
    }
}
