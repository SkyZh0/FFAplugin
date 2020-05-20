package me.skyzh0.FFAplugin;

/**
 * Created by SkyZh0 on the 18/05/2020
 */

import me.skyzh0.FFAplugin.Commands.*;
import me.skyzh0.FFAplugin.GameStateRunnable.gameWin;
import me.skyzh0.FFAplugin.Listeners.blockProtection;
import me.skyzh0.FFAplugin.Listeners.damageCanceller;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import me.skyzh0.FFAplugin.Listeners.playerJoin;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        new leaveFfaCommand(this);
        new lunchFfaCommand(this);
        new joinFfaCommand(this);
        new ffaAdminCommand(this);
        new deathEvent(this);
        new damageCanceller(this);
        new blockProtection(this);
        new debugArray(this);
        new playerJoin(this);
    }

}