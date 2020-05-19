package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.PLAYERjoining;
import me.skyzh0.FFAplugin.Runnable.leaveSpec;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class leaveFfaCommand implements CommandExecutor {
    private Main plugin;

    public leaveFfaCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("ffaleave").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (!(p instanceof Player)) {
            sender.sendMessage("Only player are able to do that");
        } else {
            BukkitTask lolMDR = new leaveSpec(p.getPlayer()).runTaskLater(plugin, 1);
        }
        return false;
    }
}

