package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.joining;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.UUID;

public class joinFfaCommand implements CommandExecutor {
    private Main plugin;

    public joinFfaCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("joinffa").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        double spawnpoint_x = plugin.getConfig().getDouble("spawnpoint_x");
        double spawnpoint_y = plugin.getConfig().getDouble("spawnpoint_y");
        double spawnpoint_z = plugin.getConfig().getDouble("spawnpoint_z");
        Location arena1 = new Location(Bukkit.getWorld("world"), spawnpoint_x, spawnpoint_y, spawnpoint_z);
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command !");
            return true;
        }
        Player p = (Player) sender;
        ArrayList<UUID> playing = new ArrayList<UUID>();
        playing.add(p.getUniqueId());
        int nPlaying = playing.size();
        boolean alreadyBroadcasting = false;
        if (!alreadyBroadcasting) {
            BukkitTask join = new joining(p.getPlayer()).runTaskTimer(plugin, 0, 20);
            alreadyBroadcasting = true;
        }
        for (UUID player : playing) {
            Bukkit.getPlayer(player).teleport(arena1);
        } /* ne pas oublier playing.clear(); dans le gameEND */
        Bukkit.broadcastMessage(Integer.toString(nPlaying));


        return false;
    }
}
