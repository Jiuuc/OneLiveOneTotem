package com.github.jiuuc.onelifeonetotem;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataType;

public class DeathEvent implements Listener {
    @EventHandler
    public static void onDeath(PlayerDeathEvent e) {
        e.getPlayer().getPersistentDataContainer().set(Main.coolDownKey, PersistentDataType.BOOLEAN, false);
        e.getPlayer().setCooldown(Material.TOTEM_OF_UNDYING, 0);
    }
}
