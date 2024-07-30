package org.quantum.quantumsAdmin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static net.kyori.adventure.text.Component.text;

public abstract class AdminTool{
    public abstract String getName();
    public abstract int getId();
    public abstract Material getItemMaterial();

    public abstract void onRightClick(Player player, PlayerInteractEvent event);

    public ItemStack createItem(ItemStack base){
        return base;
    }

    public ItemStack getItem(){
        return createItem(getBaseItem());
    }

    private ItemStack getBaseItem(){
        ItemStack item = new ItemStack(getItemMaterial());
        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.LURE,1,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        meta.displayName(toolText(getName()));
        meta.setCustomModelData(getId());
        item.setItemMeta(meta);
        return item;
    }

    private Component toolText(String name){
        return MiniMessage.miniMessage().deserialize("<dark_blue><bold><obfuscated>DW</obfuscated></bold></dark_blue> <blue>"+name+"</blue> <dark_blue><bold><obfuscated>DW</obfuscated></bold></dark_blue>").asComponent();
    }
}
