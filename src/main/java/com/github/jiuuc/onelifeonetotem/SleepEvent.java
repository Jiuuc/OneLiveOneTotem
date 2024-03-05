package com.github.jiuuc.onelifeonetotem;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;
import org.bukkit.persistence.PersistentDataType;

public class SleepEvent implements Listener {
    @EventHandler
    public static void onSleep(TimeSkipEvent e) {
        if (e.getSkipReason() != TimeSkipEvent.SkipReason.NIGHT_SKIP) return;

        for (Player player: Bukkit.getOnlinePlayers()) {
            if (player.isSleeping()) {
                player.getPersistentDataContainer().set(Main.coolDownKey, PersistentDataType.BOOLEAN, false);
                player.setCooldown(Material.TOTEM_OF_UNDYING, 0);
            }
        }
    }
}
