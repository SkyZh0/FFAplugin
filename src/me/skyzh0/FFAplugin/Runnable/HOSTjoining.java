package me.skyzh0.FFAplugin.Runnable;

import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HOSTjoining extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public HOSTjoining(Player player) {
        p = player;
    }

    public static boolean isGameRunning = false;

    @Override
    public void run() {
        TextComponent msgJoiningTimer = new TextComponent("§6Begin in " + LunchTimer + " sec");
        TextComponent error = new TextComponent("§4Not enough player to lunch the event");

        Sound counterSound = Sound.SUCCESSFUL_HIT;

        int i = 0;

        for (Player player : joinFfaCommand.playing) {
            i++;
            if (LunchTimer == 60) {
                player.spigot().sendMessage(msgJoiningTimer);
            } else if (LunchTimer == 30) {
                player.spigot().sendMessage(msgJoiningTimer);
            } else if (LunchTimer == 10) {
                player.spigot().sendMessage(msgJoiningTimer);
                player.playSound(player.getLocation(), counterSound, 100, 1);
            } else if (LunchTimer <= 5 && LunchTimer != 0) {
                player.spigot().sendMessage(msgJoiningTimer);
                player.playSound(player.getLocation(), counterSound, 100, 1);
            } else if (LunchTimer <= 0) {
                if (joinFfaCommand.playing.size() < 2) {
                    p.spigot().sendMessage(error);
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    cancel();
                } else {
                    HOSTjoining.isGameRunning = true;
                    player.playSound(player.getLocation(), Sound.ENDERDRAGON_HIT, 100, 1);
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    cancel();
                }
            }
        }
        if (LunchTimer == 60) {
            joinFfaCommand.playing.add(p);
            p.spigot().sendMessage(msgJoiningTimer);
        }
        LunchTimer--;
        HOSTjoining.LunchTimer = LunchTimer;

    }


}

