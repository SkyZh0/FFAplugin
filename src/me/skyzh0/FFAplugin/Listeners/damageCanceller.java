package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;

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

    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player hitted = (Player) e.getEntity();
            Player hitter = (Player) e.getDamager();
            if (deathEvent.diedPlayer.contains(hitter)) {
                if (hitter.isSneaking() == true) {
                    Inventory toSee = hitted.getInventory();
                    hitter.openInventory(toSee);
                    e.setCancelled(true);
                }
                e.setCancelled(true);
            }
        }
    }
}
