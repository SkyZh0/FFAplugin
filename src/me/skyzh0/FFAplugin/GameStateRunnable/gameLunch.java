package me.skyzh0.FFAplugin.GameStateRunnable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class gameLunch extends BukkitRunnable {
    Player p;
    int spawnPointX = 0;
    int spawnPointY = 83;
    int spawnPointZ = 0;
    Location arena1 = new Location(Bukkit.getWorld("world"), spawnPointX, spawnPointY, spawnPointZ);

    public gameLunch(Player player) {
        p = player;
    }

    @Override
    public void run() {
        p.teleport(arena1);
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5 * 20, 255));
        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * 20, 255));
    }
}
