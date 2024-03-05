package com.github.jiuuc.onelifeonetotem;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    private static Main instance;
    public static NamespacedKey coolDownKey;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        instance = this;
        coolDownKey = new NamespacedKey(instance, "usedTotem");

        Bukkit.getServer().getPluginManager().registerEvents(new SetTotemCooldownEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new DeathEvent(), this);

        if (getConfig().getBoolean("reload-after-sleeping"))
            Bukkit.getServer().getPluginManager().registerEvents(new SleepEvent(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
