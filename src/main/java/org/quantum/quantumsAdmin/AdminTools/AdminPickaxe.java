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
        Block target = player.getTargetBlock(null,10);
        target.breakNaturally(true);
//        float dir = player.getYaw();
//        boolean isZ = (dir>-45&&dir<45) || (dir>135 || dir<-135);

//        if(player.getPitch()>-45&&player.getPitch()<45){
//            for (int i = -1; i <= 1; i++) {
//                for (int j = -1; j <= 1; j++) {
//                    player.getWorld().setBlockData(target.getLocation().add(i,j,0),Material.AIR.createBlockData());
//                }
//            }
//            return;
//        }
//
//        if(isZ){
//            for (int i = -1; i <= 1; i++) {
//                for (int j = -1; j <= 1; j++) {
//                    player.getWorld().setBlockData(target.getLocation().add(i,0,j),Material.AIR.createBlockData());
//                }
//            }
//        }else{
//            for (int i = -1; i <= 1; i++) {
//                for (int j = -1; j <= 1; j++) {
//                    player.getWorld().setBlockData(target.getLocation().add(0,i,j),Material.AIR.createBlockData());
//                }
//            }
//        }
    }
}
