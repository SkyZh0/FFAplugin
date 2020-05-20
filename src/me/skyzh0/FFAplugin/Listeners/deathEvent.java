package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.lunchFfaCommand;
import me.skyzh0.FFAplugin.GameStateRunnable.gameWin;
import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.hideSpec;
import me.skyzh0.FFAplugin.Runnable.specMod;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class deathEvent implements Listener {
    private static Main plugin;
    public static Location deathloc;
    public static ArrayList<Player> diedPlayer = new ArrayList<Player>();

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
            p.spigot().respawn();

            Bukkit.broadcastMessage("§a" + p.getDisplayName() + " §7Got Killed and Eliminated By §c" + killer.getDisplayName());

            if (!deathEvent.diedPlayer.contains(p) && joinFfaCommand.playing.contains(p)) {
                BukkitTask mcIsShit = new specMod(p.getPlayer()).runTaskLater(plugin, 1);

                killer.setLastDamage(0);
                killer.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 25, 1));
                killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 4, 2));
                BukkitTask jehaiscejeu = new hideSpec(p.getPlayer()).runTaskLater(plugin, 1);

                deathEvent.diedPlayer.add(p);
                joinFfaCommand.playing.remove(p);
            }

            int alivePlayers = joinFfaCommand.playing.size();

            if(alivePlayers <= 1 && lunchFfaCommand.isLunched){
                BukkitTask woulaTaGagne = new gameWin(p.getPlayer()).runTaskLater(plugin, 1);
            }
        }
    }
}
