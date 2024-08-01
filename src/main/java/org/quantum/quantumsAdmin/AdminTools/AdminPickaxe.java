package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.quantum.quantumsAdmin.AdminTool;

import static org.quantum.quantumsAdmin.Util.Util.getTargetEntity;

public class AdminPickaxe extends AdminTool {

    @Override
    public ItemStack createItem(ItemStack base) {
        ItemMeta meta = base.getItemMeta();
        meta.addAttributeModifier(Attribute.PLAYER_BLOCK_BREAK_SPEED,new AttributeModifier(NamespacedKey.fromString("quantumsadmin:attack"),9999999,AttributeModifier.Operation.MULTIPLY_SCALAR_1));
        base.setItemMeta(meta);
        return base;
    }

    @Override
    public String getName() {
        return "Admin Pickaxe";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public Material getItemMaterial() {
        return Material.STONE_PICKAXE;
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        Block target = player.getTargetBlock(null,50);
        target.breakNaturally(true);
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                for (int z = -1; z <= 1; z++) {
                    player.getWorld().getBlockAt(target.getLocation().add(x, y, z)).breakNaturally(true);
                }
            }
        }
    }
}
