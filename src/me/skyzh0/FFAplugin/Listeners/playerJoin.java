package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;

public class playerJoin implements Listener {
    private static Main plugin;

    public playerJoin(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        p.setAllowFlight(true);
    }

    @EventHandler
    public void onQuit (PlayerQuitEvent event){
        Player p = event.getPlayer();
        if (joinFfaCommand.playing.contains(p)){
            joinFfaCommand.playing.remove(p);
        }
    }
}
