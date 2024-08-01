package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.quantum.quantumsAdmin.AdminTool;

import static org.quantum.quantumsAdmin.Util.Util.getTargetEntity;

public class FireballWand extends AdminTool {
    @Override
    public String getName() {
        return "Fireball Wand";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public Material getItemMaterial() {
        return Material.SPECTRAL_ARROW;
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        Fireball fireball = player.launchProjectile(Fireball.class,player.getLocation().getDirection());
        fireball.setDirection(player.getLocation().getDirection());
        fireball.setYield(10);
    }
}
