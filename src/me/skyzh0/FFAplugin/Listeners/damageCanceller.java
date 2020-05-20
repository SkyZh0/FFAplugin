package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class damageCanceller implements Listener {
    private static Main plugin;

    public damageCanceller(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player p = (Player) event.getEntity();
            if (deathEvent.diedPlayer.contains(p) || !(HOSTjoining.isGameRunning)) {
                event.setCancelled(true);
            }
        }
    }
}
