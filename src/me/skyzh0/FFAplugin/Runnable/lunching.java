package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class lunching extends BukkitRunnable {
    Player p;

    public lunching(Player player) {
        p = player;
    }

    int nRepeat = 1;

    @Override
    public void run() {
        TextComponent msg1 = new net.md_5.bungee.api.chat.TextComponent("§6FFA event lunched by §2" + p.getName() + " §6do /joinffa or click-me to join the event !");
        msg1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aJoin FFA event").create()));
        msg1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinffa"));

        TextComponent msg2 = new net.md_5.bungee.api.chat.TextComponent("§6FFA event lunched by §2" + "Console" + " §6do /joinffa or click-me to join the event !");
        msg2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aJoin FFA event").create()));
        msg2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/joinffa"));

        if (nRepeat != 0 && p instanceof Player) {
            Bukkit.spigot().broadcast(msg1);
            /*p.spigot().sendMessage(msg1);*/
        } else if (nRepeat != 0 && !(p instanceof Player)) {
            Bukkit.getConsoleSender().sendMessage(String.valueOf(msg2));
            /*p.spigot().sendMessage(msg2);*/
        } else {
            cancel();
        }
        nRepeat--;

    }

}
