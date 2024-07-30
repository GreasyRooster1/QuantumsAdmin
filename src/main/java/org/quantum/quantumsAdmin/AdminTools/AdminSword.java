package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.quantum.quantumsAdmin.AdminTool;

import static org.quantum.quantumsAdmin.Util.Util.getTarget;
import static org.quantum.quantumsAdmin.Util.Util.getTargetEntity;

public class AdminSword extends AdminTool {

    @Override
    public ItemStack createItem(ItemStack base) {
        ItemMeta meta = base.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,new AttributeModifier(NamespacedKey.fromString("quantumsadmin:attack"),9999999,AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        base.setItemMeta(meta);
        return base;
    }

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
