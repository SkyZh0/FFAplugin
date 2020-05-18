package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PLAYERjoining extends BukkitRunnable {
    Player p;

    public PLAYERjoining(Player player) {
        p = player;
    }

    boolean alreadyJoined = false;

    @Override
    public void run() {
        TextComponent joined = new TextComponent("§4 You successfully joined the FFA event !");
        if (!alreadyJoined) {
            p.spigot().sendMessage(joined);
            alreadyJoined = true;
        }

    }
}