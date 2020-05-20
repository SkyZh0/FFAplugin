package me.skyzh0.FFAplugin.Runnable;

import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class hideSpec extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public hideSpec(Player player) {
        p = player;
    }

    @Override
    public void run() {
        int i = 0;
        int j = 0;
        for (Player alive : joinFfaCommand.playing) {
            i++;
            for (Player died : deathEvent.diedPlayer) {
                alive.hidePlayer(died);
                j++;
            }
        }
    }
}
