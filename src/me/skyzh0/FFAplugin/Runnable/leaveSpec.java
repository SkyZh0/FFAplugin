package me.skyzh0.FFAplugin.Runnable;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
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
            p.sendMessage("§c You left the ffa event");
            p.getInventory().clear();
            p.setGameMode(GameMode.CREATIVE);
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
            int i = 0;
            for (Player player : Bukkit.getOnlinePlayers()) {
                p.showPlayer(player);
                player.recalculatePermissions();
                i++;
            }
        }else{
            p.sendMessage("§4 You cannot do that while you are alive");
        }

    }
}
