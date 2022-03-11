package com.jasonzhao.addon.skgrind;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import net.splodgebox.eliteenchantments.EliteEnchantmentsAPI;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;


public final class SkGrind extends JavaPlugin {
    SkGrind instance;
    SkriptAddon addon;
    @Override
    public void onEnable() {
        if(getServer().getPluginManager().getPlugin("EliteEnchantments-2.0.8-all") == null){
            Bukkit.getLogger().info("This plugin has beeen disbaled");
            return;
        }instance = this;
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
