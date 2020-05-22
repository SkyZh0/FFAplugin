package me.skyzh0.FFAplugin.Commands.editKit;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class setKit implements CommandExecutor {
    private Main plugin;

    public setKit(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("setkit").setExecutor(this);
    }

    public static Inventory kit;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("ffa.admin.editkit")) {
            setKit.kit = p.getInventory();
            p.sendMessage("§aYou successfully set the new kit !");
        }
        return false;
    }
}
