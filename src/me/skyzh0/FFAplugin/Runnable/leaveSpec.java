package me.skyzh0.FFAplugin.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;

public class leaveSpec extends BukkitRunnable {
    public static int LunchTimer = 60;
    Player p;

    public leaveSpec(Player player) {
        p = player;
    }

    int spawnPointX = 0;
    int spawnPointY = 83;
    int spawnPointZ = 0;
    Location Spawn = new Location(Bukkit.getWorld("world"), spawnPointX, spawnPointY, spawnPointZ);

    @Override
    public void run() {
        if (deathEvent.diedPlayer.contains(p)) {
            p.getInventory().clear();
            p.teleport(Spawn);
            p.updateInventory();
            p.setHealth(p.getMaxHealth());
            p.setFoodLevel(20);
            p.setExp(0);
            p.setLevel(0);
            p.recalculatePermissions();
            PermissionAttachment attachment = p.addAttachment((Plugin) this);
            attachment.setPermission("ffaplugin.templunchingperm", true);
            attachment.setPermission("ffa.alreadylunchedbg", true);
            p.recalculatePermissions();
            int i = 0;
            for (Player player : Bukkit.getOnlinePlayers()) {
                p.showPlayer(player);
                joinFfaCommand.playing.remove(p);
                deathEvent.diedPlayer.remove(p);
                i++;
            }
        }

    }
}
