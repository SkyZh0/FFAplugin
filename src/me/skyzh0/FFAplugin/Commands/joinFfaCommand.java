package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.GameStateRunnable.gameLunch;
import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import me.skyzh0.FFAplugin.Runnable.PLAYERjoining;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.UUID;

public class joinFfaCommand implements CommandExecutor {
    private Main plugin;

    public joinFfaCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("joinffa").setExecutor(this);
    }
    public static ArrayList<Player> playing;

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
        PermissionAttachment attachment = p.addAttachment(plugin);
        joinFfaCommand.playing.add(p);
        int LunchTimer = 61;

        if (p.hasPermission("ffaplugin.templunchingperm")) {
            BukkitTask run = new PLAYERjoining(p.getPlayer()).runTaskLater(plugin, 1);
            BukkitTask mdr = new gameLunch(p.getPlayer()).runTaskLater(plugin, HOSTjoining.LunchTimer * 20);
            attachment.setPermission("ffaplugin.templunchingperm", false);
            /* mettre
            attachment.setPermission("ffaplugin.templunchingperm", true);
            DANS LE GAME END */
        } else {
            p.sendMessage("§c You already joined !");
            /* DEBUG LINE
            attachment.setPermission("ffaplugin.templunchingperm", true);
             */
        }
        return false;
    }
}
