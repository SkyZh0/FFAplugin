package me.skyzh0.FFAplugin.Runnable;

import me.skyzh0.FFAplugin.Listeners.deathEvent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class hideSpec extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public hideSpec(Player player) {
        p = player;
    }
    int counter = deathEvent.diedPlayer.size();

    @Override
    public void run() {
        while (counter >= 0){
            p.hidePlayer(deathEvent.diedPlayer.get(counter));
            counter--;
        }
    }
}
