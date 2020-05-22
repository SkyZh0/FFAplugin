package me.skyzh0.FFAplugin.Scoreboard;

import io.github.thatkawaiisam.assemble.AssembleAdapter;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;

import java.util.ArrayList;
import java.util.List;

public class AssembleScoreboard implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return ChatColor.GOLD.toString() + "FFA Event";
    }

    @Override
    public List<String> getLines(Player player) {
        final List<String> toReturn = new ArrayList<>();

        toReturn.add("");
        toReturn.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        toReturn.add("");
        if (lunchFfaCommand.isLunched) {
            toReturn.add("&aAlive PLayers : " + ChatColor.WHITE + joinFfaCommand.playing.size());
            if (deathEvent.diedPlayer.size() > 0) {
                toReturn.add("");
                toReturn.add("&aParticipants : " + ChatColor.WHITE + deathEvent.diedPlayer.size());
                toReturn.add("");
            }
            if (HOSTjoining.LunchTimer >= 0) {
                toReturn.add("&aBegin in : " + ChatColor.WHITE + HOSTjoining.LunchTimer);
            }
        } else {
            toReturn.add("&aNo event have been lunched");
        }
        toReturn.add("");
        toReturn.add("-*-*-*-*-*-*-*-*-*-*-*-*-*-");

        return toReturn;
    }

}
