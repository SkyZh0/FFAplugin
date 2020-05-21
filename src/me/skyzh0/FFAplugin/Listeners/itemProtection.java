package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class itemProtection implements Listener {
    private static Main plugin;

    public itemProtection(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if (deathEvent.diedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void PickupItem(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        if (deathEvent.diedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }

}
