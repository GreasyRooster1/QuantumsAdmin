package org.quantum.quantumsAdmin.AdminTools;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.quantum.quantumsAdmin.AdminTool;

public class LightningWand extends AdminTool {
    @Override
    public String getName() {
        return "Lightning Wand";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public Material getItemMaterial() {
        return Material.BREEZE_ROD;
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        Block target = player.getTargetBlock(null,200);
        player.getWorld().strikeLightning(target.getLocation());
    }
}
