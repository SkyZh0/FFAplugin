package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.Listeners.deathEvent;
import me.skyzh0.FFAplugin.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class specUiCommand implements CommandExecutor {
    private Main plugin;

    public specUiCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("specui").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player p = (Player) commandSender;

        if (deathEvent.diedPlayer.contains(p)) {
            p.openInventory(this.plugin.getSpecUI().GUI(p));
        } else if (p.hasPermission("ffaplugin.admin.gui")) {
            p.openInventory(this.plugin.getSpecUI().GUI(p));
        } else {
            p.sendMessage("§cYou don't have the permission or you are not spectator");
        }
        return false;
    }
}
