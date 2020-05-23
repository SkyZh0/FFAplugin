package me.skyzh0.FFAplugin.Runnable.GameStateRunnable;

import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class gameLunch extends BukkitRunnable {
    Player p;

    public gameLunch(Player player) {
        p = player;
    }

    @Override
    public void run() {
        if (!(joinFfaCommand.playing.size() >= 2)) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!(joinFfaCommand.playing.contains(player))) {
                }
            }
            cancel();
        } else {
            for (Player playing : joinFfaCommand.playing) {
                playing.setFlying(false);
                playing.setAllowFlight(false);
            }
            p.teleport(lunchFfaCommand.Arena1);
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5 * 20, 255));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * 20, 255));
            p.setGameMode(GameMode.SURVIVAL);
            p.setHealth(p.getMaxHealth());
            p.setFoodLevel(20);
            p.setExp(0);
            p.setLevel(0);
        }
    }
}
