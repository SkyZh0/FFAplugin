package me.skyzh0.FFAplugin;

/**
 * Created by SkyZh0 on the 18/05/2020
 */

import me.skyzh0.FFAplugin.Commands.*;
import me.skyzh0.FFAplugin.Listeners.*;
import me.skyzh0.FFAplugin.specUI.specUI;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private me.skyzh0.FFAplugin.specUI.specUI specUI;

    public specUI getSpecUI() {
        return this.specUI;
    }

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
        new inventoryClick(this);
        new specUiCommand(this);
        new itemProtection(this);

        this.specUI = new specUI();


    }

}