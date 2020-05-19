package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;

public class HOSTjoining extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public HOSTjoining(Player player) {
        p = player;
    }

    @Override
    public void run() {
        TextComponent msgJoiningTimer = new TextComponent("§6 lunching in " + LunchTimer + " sec");
        TextComponent error = new TextComponent("§4 Not enough player to lunch the event");
        if (LunchTimer == 60) {
            p.spigot().sendMessage(msgJoiningTimer);
        } else if (LunchTimer == 30) {
            p.spigot().sendMessage(msgJoiningTimer);
        } else if (LunchTimer == 10) {
            Bukkit.spigot().broadcast(msgJoiningTimer);
        } else if (LunchTimer <= 5 && LunchTimer != 0) {
            p.spigot().sendMessage(msgJoiningTimer);
        } else if (LunchTimer == 0 ) {
            if (joinFfaCommand.playing.size() >= 2){
                p.spigot().sendMessage(error);
                cancel();
            }
        }
        LunchTimer--;
        HOSTjoining.LunchTimer = LunchTimer;

    }


}

