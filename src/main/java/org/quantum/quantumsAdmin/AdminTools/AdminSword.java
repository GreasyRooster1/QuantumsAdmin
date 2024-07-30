package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.quantum.quantumsAdmin.AdminTool;

public class AdminSword extends AdminTool {
    @Override
    public ItemStack createItem(ItemStack base) {
        return base.clone();
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
}
