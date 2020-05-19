package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.PLAYERjoining;
import me.skyzh0.FFAplugin.Runnable.specMod;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitTask;

public class deathEvent implements Listener {
    private static Main plugin;
    public static Location deathloc;

    public deathEvent(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPLayerDeath(PlayerDeathEvent e) {
        if (e.getEntity().getKiller() instanceof Player) {
            Player killer = e.getEntity().getKiller();
            Player p = e.getEntity();
            deathEvent.deathloc = p.getLocation();
            Bukkit.broadcastMessage("§a" + p.getDisplayName() + " §7Got Killed and Eliminated By §c" + killer.getDisplayName());
            if (p.isDead()) {
                BukkitTask mcIsShit = new specMod(p.getPlayer()).runTaskLater(plugin, 1);
                p.spigot().respawn();
            }
        }
    }
}
