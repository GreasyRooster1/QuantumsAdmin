package org.quantum.quantumsAdmin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.quantum.quantumsAdmin.Commands.*;
import org.quantum.quantumsAdmin.Events.PlayerEvents;

public final class QuantumsAdmin extends JavaPlugin {
    static QuantumsAdmin plugin;

    @Override
    public void onEnable() {
        plugin = this;

        disablePvp();

        registerCommands();
        registerEvents();
    }

    public void disablePvp(){
        for(World w : Bukkit.getWorlds()){
            w.setPVP(false);
        }
    }

    public void registerEvents() {
        Listener eventListener = new PlayerEvents();
        Bukkit.getPluginManager().registerEvents( eventListener, this );
    }

    public void registerCommands() {
        new TestCommand().register();
        new HealCommand().register();
        new ExplodeCommand().register();
        new SmiteCommand().register();
        new IgniteCommand().register();
        new FlyCommand().register();
        new MultiSpawn().register();
        new DisableCommand().register();
        new ToolsCommand().register();
        new PVPCommand().register();
    }

    @Override
    public void onDisable() {
    }

    public static QuantumsAdmin getInstance(){
        return plugin;
    }
}
