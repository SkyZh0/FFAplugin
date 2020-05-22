package me.skyzh0.FFAplugin.Runnable.spec;

import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
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
        for (Player alive : joinFfaCommand.playing) {
            for (Player died : deathEvent.diedPlayer) {
                alive.hidePlayer(died);
            }
        }
    }
}
