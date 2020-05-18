package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class joining extends BukkitRunnable {
    Player p;

    public joining(Player player) {
        p = player;
    }

    int LunchTimer = 61;
    boolean alreadyJoined = false;

    @Override
    public void run() {
        TextComponent msgJoiningTimer = new TextComponent("§6 lunching in " + LunchTimer + " sec");
        TextComponent joined = new TextComponent("§4 You successfully joined the FFA event !");
        if (!alreadyJoined) {
            p.spigot().sendMessage(joined);
            alreadyJoined = true;
        }
        if (LunchTimer == 60) {
            Bukkit.spigot().broadcast(msgJoiningTimer);
        } else if (LunchTimer == 30) {
            Bukkit.spigot().broadcast(msgJoiningTimer);
        } else if (LunchTimer == 10) {
            Bukkit.spigot().broadcast(msgJoiningTimer);
        } else if (LunchTimer <= 5 && LunchTimer != 0) {
            Bukkit.spigot().broadcast(msgJoiningTimer);
        } else if (LunchTimer == 0) {
            cancel();
        }
        LunchTimer--;

    }


}

