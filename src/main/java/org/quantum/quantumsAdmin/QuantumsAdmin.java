package org.quantum.quantumsAdmin;

import org.bukkit.plugin.java.JavaPlugin;
import org.quantum.quantumsAdmin.Commands.ExplodeCommand;
import org.quantum.quantumsAdmin.Commands.HealCommand;
import org.quantum.quantumsAdmin.Commands.SmiteCommand;
import org.quantum.quantumsAdmin.Commands.TestCommand;

public final class QuantumsAdmin extends JavaPlugin {
    static QuantumsAdmin plugin;


    @Override
    public void onEnable() {
        plugin = this;

        registerCommands();
    }

    public void registerCommands() {
        new TestCommand().register();
        new HealCommand().register();
        new ExplodeCommand().register();
        new SmiteCommand().register();
    }

    @Override
    public void onDisable() {
    }

    public static QuantumsAdmin getInstance(){
        return plugin;
    }
}
