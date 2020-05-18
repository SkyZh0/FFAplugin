package me.skyzh0.FFAplugin.Commands;

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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int interval = 2;
        Player p = (Player) sender;
        PermissionAttachment attachment = p.addAttachment(plugin);

        if (!(sender instanceof Player)) {
            BukkitTask lunch = new lunching(p.getPlayer()).runTaskTimer(plugin, 0, interval * 20);
            BukkitTask join = new HOSTjoining(p.getPlayer()).runTaskTimer(plugin, 0, 20);
        }

        if (p.hasPermission("ffa.lunchffa") {
            if (p.hasPermission("ffa.alreadylunchedbg")) {
                BukkitTask lunch = new lunching(p.getPlayer()).runTaskTimer(plugin, 0, interval * 20);
                BukkitTask join = new HOSTjoining(p.getPlayer()).runTaskTimer(plugin, 0, 20);
                attachment.setPermission("ffa.alreadylunchedbg", false);
            } else {
                p.sendMessage("An FFA event is already lunched");
            }
        } else{
            p.sendMessage("§cSorry but you don't have the permission !");
        }
        return false;
    }

}
