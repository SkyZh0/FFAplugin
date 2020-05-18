package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

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
        return false;
    }
}
