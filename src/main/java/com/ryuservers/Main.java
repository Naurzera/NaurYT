package com.ryuservers;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    private static Main INSTANCE;
    public static Main getInstance(){
        return INSTANCE;
    }


    @Override
    public void onEnable() {

        INSTANCE = this;

        saveDefaultConfig();

        getServer().getConsoleSender().sendMessage("");
        getServer().getConsoleSender().sendMessage("§aNaurYT Habilitado");
        getServer().getConsoleSender().sendMessage("");

        getServer().getPluginManager().registerEvents(new Listener(), this);

        getCommand("yt").setExecutor(new Command());
        getCommand("youtuber").setExecutor(new Command());
    }
}
