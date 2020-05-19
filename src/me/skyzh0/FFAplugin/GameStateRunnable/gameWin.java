package me.skyzh0.FFAplugin.GameStateRunnable;

import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_7_R4.Entity;
import net.minecraft.server.v1_7_R4.EntityFireworks;
import org.bukkit.*;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftFirework;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.lunchFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;

import java.util.Locale;

public class gameWin extends BukkitRunnable {
    Player p;
    public gameWin(Player player) {
        p = player;
    }
    @Override
    public void run() {
        Player winner = joinFfaCommand.playing.get(0);
        TextComponent msg1 = new net.md_5.bungee.api.chat.TextComponent("§6" + winner.getName() + " §b won the FFA event !");
        winner.setGameMode(GameMode.CREATIVE);
        winner.getInventory().clear();
        winner.updateInventory();
        winner.setHealth(p.getMaxHealth());
        winner.setFoodLevel(20);
        winner.setExp(0);
        winner.setLevel(0);

        Location location = winner.getLocation();
        World world = location.getWorld();
        world.playSound(location, Sound.WITHER_DEATH, 100, 1);

        int nFireWorks = 5;
        while (nFireWorks > 0){
            Firework f = (Firework) winner.getPlayer().getWorld().spawn(winner.getPlayer().getLocation(), Firework.class);
            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(FireworkEffect.builder()
                    .flicker(false)
                    .trail(false)
                    .with(FireworkEffect.Type.BALL)
                    .withColor(Color.ORANGE)
                    .withFade(Color.WHITE)
                    .build());
            fm.setPower(1);
            f.setFireworkMeta(fm);
            nFireWorks --;
        }

        lunchFfaCommand.isLunched = false;
        joinFfaCommand.playing.clear();
        deathEvent.diedPlayer.clear();

        int i = 0;
        int spawnPointX = 0;
        int spawnPointY = 83;
        int spawnPointZ = 0;
        Location Spawn = new Location(Bukkit.getWorld("world"), spawnPointX, spawnPointY, spawnPointZ);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.showPlayer(player);
            player.recalculatePermissions();
            joinFfaCommand.playing.remove(p);
            deathEvent.diedPlayer.remove(p);
            player.teleport(Spawn);
            i++;
        }

    }
}
