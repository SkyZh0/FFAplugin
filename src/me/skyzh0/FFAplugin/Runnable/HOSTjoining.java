package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HOSTjoining extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public HOSTjoining(Player player) {
        p = player;
    }

    boolean alreadyJoined = false;

    @Override
    public void run() {
        TextComponent msgJoiningTimer = new TextComponent("§6 lunching in " + LunchTimer + " sec");
        TextComponent joined = new TextComponent("§4 You successfully joined the FFA event !");
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
        HOSTjoining.LunchTimer = LunchTimer;

    }


}

