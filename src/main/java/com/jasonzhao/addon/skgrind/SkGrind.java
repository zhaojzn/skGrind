package com.jasonzhao.addon.skgrind;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;


public final class SkGrind extends JavaPlugin {
    SkGrind instance;
    SkriptAddon addon;

    public static void main(String[] args) {

    }
    @Override

    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("EliteEnchantments") == null){
            Bukkit.getLogger().info("[SkGrind] This plugin has beeen disbaled");
            return;
        }


        instance = this;
        addon = Skript.registerAddon(this);
        try {
            //This will register all our syntax for us. Explained below
            addon.loadClasses("com.jasonzhao.addon.skgrind", "elements");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bukkit.getLogger().info("[SkGrind] has been enabled!");

    }
    public SkGrind getInstance() {
        return instance;
    }

    public SkriptAddon getAddonInstance() {
        return addon;
    }

}
