package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockProtection implements Listener {
    private static Main plugin;

    public blockProtection(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent blockBreakEvent) {
        Player p = blockBreakEvent.getPlayer();
        if (!(p.hasPermission("ffa.admin.build"))) {
            blockBreakEvent.setCancelled(true);
        }
        if (p.hasPermission("ffa.admin.build") && HOSTjoining.isGameRunning) {
            blockBreakEvent.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent placeEvent) {
        Player p = placeEvent.getPlayer();
        if (!(p.hasPermission("ffa.admin.build"))) {
            placeEvent.setCancelled(true);
        }
        if (p.hasPermission("ffa.admin.build") && HOSTjoining.isGameRunning) {
            placeEvent.setCancelled(true);
        }
    }
}
