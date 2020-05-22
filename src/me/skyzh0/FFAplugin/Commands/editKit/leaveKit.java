package me.skyzh0.FFAplugin.Commands.editKit;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class leaveKit implements CommandExecutor {
    private Main plugin;

    public leaveKit(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("leavekit").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("ffa.admin.editkit")) {
            if (editKit.isEditing) {
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.updateInventory();
                Location toTeleport = new Location(Bukkit.getWorld("world"), plugin.getConfig().getInt("spawnpoint_x"), plugin.getConfig().getInt("spawnpoint_y"), plugin.getConfig().getInt("spawnpoint_z"));
                ((Player) sender).getPlayer().teleport(toTeleport);
                p.sendMessage("§aYou successfully left the kit editor !");
            }else {
                p.sendMessage("§cYou are not editing !");
            }
        }
        return false;
    }
}
