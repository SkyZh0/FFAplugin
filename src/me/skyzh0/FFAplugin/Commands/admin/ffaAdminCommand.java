package me.skyzh0.FFAplugin.Commands.admin;

import me.skyzh0.FFAplugin.Runnable.GameStateRunnable.gameWin;
import me.skyzh0.FFAplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitTask;

public class ffaAdminCommand implements CommandExecutor {
    private Main plugin;

    public ffaAdminCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("ffaadmin").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        PermissionAttachment attachment = p.addAttachment(plugin);
        attachment.setPermission("ffaplugin.templunchingperm", true);
        attachment.setPermission("ffa.alreadylunchedbg", true);
        BukkitTask lalal = new gameWin(p.getPlayer()).runTaskLater(plugin, 1);
        return false;
    }
}
