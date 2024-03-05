package com.github.jiuuc.onelifeonetotem;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;

public class SetTotemCooldownEvent implements Listener {
    private static final int cooldownTime = Main.getInstance().getConfig().getInt("cooldown-time");

    @EventHandler
    public void onUse(EntityResurrectEvent e) {
        if (!(e.getEntity() instanceof Player player)) return;

        if (player.getCooldown(Material.TOTEM_OF_UNDYING) == 0) {
            player.getPersistentDataContainer().set(Main.coolDownKey, PersistentDataType.BOOLEAN, true);
            player.setCooldown(Material.TOTEM_OF_UNDYING, cooldownTime);
        }
        else e.setCancelled(true);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().getPersistentDataContainer().has(Main.coolDownKey)) return;
        if (!e.getPlayer().getPersistentDataContainer().get(Main.coolDownKey, PersistentDataType.BOOLEAN)) return;

        e.getPlayer().setCooldown(Material.TOTEM_OF_UNDYING, cooldownTime);
    }
}
