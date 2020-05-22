package me.skyzh0.FFAplugin.Commands.editKit;

import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;
import me.skyzh0.FFAplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class editKit implements CommandExecutor {
    private Main plugin;

    public editKit(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("editkit").setExecutor(this);
    }

    private static World world = Bukkit.getWorld("world");
    public static Location EditKit;
    public static boolean isEditing;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        editKit.EditKit = new Location(world, plugin.getConfig().getInt("editKitLoc_x"), plugin.getConfig().getInt("editKitLoc_y"), plugin.getConfig().getInt("editKitLoc_z"));
        if (p.hasPermission("ffa.admin.editkit")) {
            if (!lunchFfaCommand.isLunched) {
                p.teleport(EditKit);
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.updateInventory();
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage("§aYou successfully joined the kit editor !");

                if (setKit.kit != null) {
                    p.getInventory().setContents(setKit.kit.getContents());
                    p.getInventory().setArmorContents(setKit.kit.getContents());
                    p.updateInventory();
                }else {
                    p.sendMessage("§cNo kit loaded because no kit have been set by the past !");
                }
                editKit.isEditing = true;
            }else {
                p.sendMessage("§cSorry but a game is lunched !");
            }
        }
        return false;
    }
}
