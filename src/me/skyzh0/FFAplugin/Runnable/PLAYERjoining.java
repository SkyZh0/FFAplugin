package me.skyzh0.FFAplugin.Runnable;

import me.skyzh0.FFAplugin.GameStateRunnable.gameLunch;
import me.skyzh0.FFAplugin.Main;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class PLAYERjoining extends BukkitRunnable {
    Player p;

    public PLAYERjoining(Player player) {
        p = player;
    }


    @Override
    public void run() {
        TextComponent joined = new TextComponent("§4 You successfully joined the FFA event !");
        p.spigot().sendMessage(joined);


    }

}
