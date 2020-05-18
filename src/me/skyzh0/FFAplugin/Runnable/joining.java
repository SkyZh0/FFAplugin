package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;

public class joining extends BukkitRunnable {
    Player p;

    public joining(Player player) {
        p = player;
    }

    int LunchTimer = 61;


    @Override
    public void run() {
        TextComponent msgJoiningTimer = new TextComponent("§6 lunching in " + LunchTimer + " sec");
        TextComponent notEn = new TextComponent("§4 Sorry, there is not enought players to lunch");
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
