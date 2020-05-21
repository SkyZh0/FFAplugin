package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PLAYERjoining extends BukkitRunnable {
    Player p;

    public PLAYERjoining(Player player) {
        p = player;
    }


    @Override
    public void run() {
        TextComponent joined = new TextComponent("§4You successfully joined the FFA event !");
        p.spigot().sendMessage(joined);
        p.setAllowFlight(true);
        p.setFlying(true);


    }

}
