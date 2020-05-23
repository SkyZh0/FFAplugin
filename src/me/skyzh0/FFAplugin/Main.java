package me.skyzh0.FFAplugin;

/**
 * Created by SkyZh0 on the 18/05/2020
 */

import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import me.skyzh0.FFAplugin.Commands.admin.debugArray;
import me.skyzh0.FFAplugin.Commands.admin.ffaAdminCommand;
import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.leaveFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;
import me.skyzh0.FFAplugin.Commands.spec.specUiCommand;
import me.skyzh0.FFAplugin.GUI.kitsUI.kitsUI;
import me.skyzh0.FFAplugin.GUI.specUI.specUI;
import me.skyzh0.FFAplugin.Listeners.*;
import me.skyzh0.FFAplugin.Scoreboard.AssembleScoreboard;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private me.skyzh0.FFAplugin.GUI.specUI.specUI specUI;

    public specUI getSpecUI() {
        return this.specUI;
    }


    private me.skyzh0.FFAplugin.GUI.kitsUI.kitsUI kitsUI;

    public me.skyzh0.FFAplugin.GUI.kitsUI.kitsUI getKitsUI() {
        return this.kitsUI;
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
        this.kitsUI = new kitsUI();

        //Start Instance
        Assemble assemble = new Assemble(this, new AssembleScoreboard());

        //Set Interval (Tip: 20 ticks = 1 second)
        assemble.setTicks(2);

        //Set Style (Tip: Viper Style starts at -1 and goes down)
        assemble.setAssembleStyle(AssembleStyle.VIPER);


    }

}