package me.skyzh0.FFAplugin.Runnable.spec;

import me.skyzh0.FFAplugin.Listeners.deathEvent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import static me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand.specLoc;

public class leaveSpec extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public leaveSpec(Player player) {
        p = player;
    }


    @Override
    public void run() {
        if (deathEvent.diedPlayer.contains(p)) {
            p.sendMessage("§c You left the ffa event");
            p.getInventory().clear();
            p.setGameMode(GameMode.CREATIVE);
            p.teleport(specLoc);
            p.getInventory().clear();
            p.updateInventory();
            p.setHealth(p.getMaxHealth());
            p.setFoodLevel(20);
            p.setExp(0);
            p.setLevel(0);
            p.recalculatePermissions();
            for (Player player : Bukkit.getOnlinePlayers()) {
                p.showPlayer(player);
                player.recalculatePermissions();
            }
        } else {
            p.sendMessage("§4 You cannot do that while you are alive");
        }

    }
}
