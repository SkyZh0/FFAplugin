package me.skyzh0.FFAplugin.Runnable;

import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class specMod extends BukkitRunnable {
    Player p;
    public static boolean isSpectating = false;

    public specMod(Player player) {
        p = player;
    }

    int counter = joinFfaCommand.playing.size();

    @Override
    public void run() {
        TextComponent begin = new TextComponent("§7 You entered in spectator mod, do /ffaleave to leave the event");
        p.teleport(deathEvent.deathloc);
        p.getWorld().strikeLightning(deathEvent.deathloc);
        p.spigot().sendMessage(begin);
        p.setGameMode(GameMode.SURVIVAL);
        p.setAllowFlight(true);
        p.getInventory().clear();
        p.setCanPickupItems(false);
        specMod.isSpectating = true;

    }
}
