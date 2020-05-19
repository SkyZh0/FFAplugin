package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import net.minecraft.server.v1_7_R4.Block;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import me.skyzh0.FFAplugin.Runnable.specMod;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockProtection implements Listener {
    private static Main plugin;

    public blockProtection(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent blockBreakEvent) {
        blockBreakEvent.setCancelled(true);
    }
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent placeEvent){
        placeEvent.setCancelled(true);
    }
}
