package org.quantum.quantumsAdmin.Util;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.print.Paper;

public class Chat {
    public static void sendError(CommandSender sender, String message){
        send(sender,message,"<red>");
    }
    public static void sendWarn(CommandSender sender, String message){
        send(sender,message,"<yellow>");
    }
    public static void sendSuccess(CommandSender sender, String message){
        send(sender,message,"<green>");
    }
    public static void sendMinor(CommandSender sender, String message){
        send(sender,message,"<gray>");
    }

    public static void send(CommandSender sender, String message, String style){
        String postStyle = style.replace("<","</");
        sender.sendRichMessage(style+message+postStyle);
    }
    public static void send(CommandSender sender, String message){
        sender.sendRichMessage(message);
    }
    public static void broadcast(CommandSender sender, String message){
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendRichMessage(message);
        }
    }
}
