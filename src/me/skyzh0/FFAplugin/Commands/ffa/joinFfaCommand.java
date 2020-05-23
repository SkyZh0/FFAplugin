package me.skyzh0.FFAplugin.Commands.ffa;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.GameStateRunnable.gameLunch;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import me.skyzh0.FFAplugin.Runnable.ffa.PLAYERjoining;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;

public class joinFfaCommand implements CommandExecutor {
    private Main plugin;

    public joinFfaCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("joinffa").setExecutor(this);
    }

    public static ArrayList<Player> playing = new ArrayList<Player>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        /***
         double spawnpoint_x = plugin.getConfig().getDouble("spawnpoint_x");
         double spawnpoint_y = plugin.getConfig().getDouble("spawnpoint_y");
         double spawnpoint_z = plugin.getConfig().getDouble("spawnpoint_z");
         Location arena1 = new Location(Bukkit.getWorld("world"), spawnpoint_x, spawnpoint_y, spawnpoint_z);
         ***/
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command !");
            return true;
        }
        Player p = (Player) sender;
        int LunchTimer = 60;
        if (lunchFfaCommand.isLunched) {
            if (p == lunchFfaCommand.host) {
                p.sendMessage("§c Sorry but you've already joined the event !");
                return true;
            }
            if (joinFfaCommand.playing.contains(p)) {
                p.sendMessage("§c Sorry but you've already joined the event !");
                return true;
            }
            BukkitTask run = new PLAYERjoining(p.getPlayer()).runTaskLater(plugin, 1);
            BukkitTask mdr = new gameLunch(p.getPlayer()).runTaskLater(plugin, HOSTjoining.LunchTimer * 20);
            p.setFlying(true);
            joinFfaCommand.playing.add(p);
        } else {
            p.sendMessage("§c Sorry but no ffa event are lunched yet");
        }
        return false;
    }
}
