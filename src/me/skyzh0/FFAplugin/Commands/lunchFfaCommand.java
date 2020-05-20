package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.GameStateRunnable.gameLunch;
import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import me.skyzh0.FFAplugin.Runnable.lunching;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitTask;

public class lunchFfaCommand implements CommandExecutor {
    private Main plugin;

    public lunchFfaCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("lunchffa").setExecutor(this);
    }

    public static boolean isLunched = false;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int interval = 1;
        Player p = (Player) sender;

        if (!(sender instanceof Player)) {
            if (!lunchFfaCommand.isLunched) {
                BukkitTask lunch = new lunching(p.getPlayer()).runTaskTimer(plugin, 0, interval * 20);
                BukkitTask join = new HOSTjoining(p.getPlayer()).runTaskTimer(plugin, 0, 20);
                BukkitTask mdr = new gameLunch(p.getPlayer()).runTaskLater(plugin, HOSTjoining.LunchTimer);
                joinFfaCommand.playing.add(p);
                lunchFfaCommand.isLunched = true;
            }
        }

        if (p.hasPermission("ffa.lunchffa")) {
            if (!lunchFfaCommand.isLunched) {
                BukkitTask lunch = new lunching(p.getPlayer()).runTaskTimer(plugin, 0, interval);
                BukkitTask join = new HOSTjoining(p.getPlayer()).runTaskTimer(plugin, 0, 20);
                BukkitTask mdr = new gameLunch(p.getPlayer()).runTaskLater(plugin, HOSTjoining.LunchTimer * 20);
                lunchFfaCommand.isLunched = true;
            } else {
                p.sendMessage("§c Sorry, but another FFA event is already lunched");
            }
        } else {
            p.sendMessage("§cSorry but you don't have the permission !");
        }
        return false;
    }

}
