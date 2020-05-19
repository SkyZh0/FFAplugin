package me.skyzh0.FFAplugin.Runnable;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Listeners.deathEvent;

import javax.xml.soap.Text;

public class specMod extends BukkitRunnable {
    Player p;
    public static boolean isSpectating = false;

    public specMod(Player player) {
        p = player;
    }

    @Override
    public void run() {
        TextComponent begin = new TextComponent("§7 You entered in spectator mod, do /ffaleave to leave the event");
        p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 0));
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
