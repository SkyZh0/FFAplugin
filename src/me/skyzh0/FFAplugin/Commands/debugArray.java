package me.skyzh0.FFAplugin.Commands;

import me.skyzh0.FFAplugin.Listeners.deathEvent;
import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class debugArray implements CommandExecutor {
    private Main plugin;

    public debugArray(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("admindebug").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("ffa.admin.debug")){
            int joinffaArraySize = joinFfaCommand.playing.size();
            p.sendMessage("PLayingArraySize = " + joinffaArraySize);
            p.sendMessage("playingArrayContent = " + joinFfaCommand.playing);

            int deathArraySize = deathEvent.diedPlayer.size();
            p.sendMessage("DiedArraySize = " + deathArraySize);
            p.sendMessage("DiedArrayContent = " + deathEvent.diedPlayer);

            p.sendMessage("IsGameRunning State = " + HOSTjoining.isGameRunning);
            p.sendMessage("IsGameLunched State = " + lunchFfaCommand.isLunched);
        }
        return false;
    }
}


