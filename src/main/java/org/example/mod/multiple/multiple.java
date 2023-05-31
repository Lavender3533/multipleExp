package org.example.mod.multiple;

import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.mod.multiple.commands.command;
import org.example.mod.multiple.expDouble.doubleExp;
import org.example.mod.multiple.util.MyC;

public final class multiple extends JavaPlugin implements Listener {
    public static multiple expmain;
    public static boolean activity = false;

    //public static EXP activity;
    @Override
    public void onEnable() {
        expmain = this;
        saveDefaultConfig();
        MyC.f();
        Bukkit.getConsoleSender().sendMessage("======E=======E=======E=======E===================================");
        Bukkit.getConsoleSender().sendMessage("========X===X===X===X===X===X==start==============================");
        Bukkit.getConsoleSender().sendMessage("==========P=======P=======P========================By:lavender3533");
        PluginCommand pluginCommand = getCommand("multiple");
        assert pluginCommand != null;
        pluginCommand.setExecutor(new command());
        Bukkit.getServer().getPluginManager().registerEvents(new doubleExp(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("Exp----------quite--------------------quite----------Exp");
    }
}
