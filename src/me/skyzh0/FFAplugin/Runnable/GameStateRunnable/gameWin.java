package me.skyzh0.FFAplugin.Runnable.GameStateRunnable;

import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

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

        Bukkit.spigot().broadcast(msg1);

        Location location = winner.getLocation();
        World world = location.getWorld();
        world.playSound(location, Sound.WITHER_DEATH, 100, 1);


        for (Player player : Bukkit.getOnlinePlayers()) {

            for (Player all : Bukkit.getOnlinePlayers()) {
                player.showPlayer(all);
            }

            player.recalculatePermissions();
            joinFfaCommand.playing.remove(p);
            deathEvent.diedPlayer.remove(p);
            player.teleport(lunchFfaCommand.Spawn);

        }
        int nFireWorks = 10;
        while (nFireWorks > 0) {
            Firework f = (Firework) winner.getPlayer().getWorld().spawn(winner.getPlayer().getLocation(), Firework.class);
            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(FireworkEffect.builder()
                    .flicker(false)
                    .trail(false)
                    .with(FireworkEffect.Type.BALL)
                    .withColor(Color.ORANGE)
                    .withFade(Color.WHITE)
                    .build());
            fm.setPower(0);
            f.setFireworkMeta(fm);
            nFireWorks--;
        }

        lunchFfaCommand.isLunched = false;
        HOSTjoining.isGameRunning = false;
        joinFfaCommand.playing.clear();
        deathEvent.diedPlayer.clear();
        HOSTjoining.LunchTimer = 60;

        for (Player playing : Bukkit.getOnlinePlayers()) {
            playing.getInventory().clear();
            playing.setAllowFlight(true);
            playing.setFlying(true);
        }

    }
}
