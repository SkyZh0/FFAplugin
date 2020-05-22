package me.skyzh0.FFAplugin;

/**
 * Created by SkyZh0 on the 18/05/2020
 */

import io.github.thatkawaiisam.assemble.Assemble;
import io.github.thatkawaiisam.assemble.AssembleStyle;
import me.skyzh0.FFAplugin.Commands.admin.debugArray;
import me.skyzh0.FFAplugin.Commands.admin.ffaAdminCommand;
import me.skyzh0.FFAplugin.Commands.editKit.editKit;
import me.skyzh0.FFAplugin.Commands.editKit.leaveKit;
import me.skyzh0.FFAplugin.Commands.editKit.setKit;
import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.leaveFfaCommand;
import me.skyzh0.FFAplugin.Commands.ffa.lunchFfaCommand;
import me.skyzh0.FFAplugin.Commands.spec.specUiCommand;
import me.skyzh0.FFAplugin.Listeners.*;
import me.skyzh0.FFAplugin.Scoreboard.AssembleScoreboard;
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

        new editKit(this);
        new leaveKit(this);
        new setKit(this);

        this.specUI = new specUI();

        //Start Instance
        Assemble assemble = new Assemble(this, new AssembleScoreboard());

        //Set Interval (Tip: 20 ticks = 1 second)
        assemble.setTicks(2);

        //Set Style (Tip: Viper Style starts at -1 and goes down)
        assemble.setAssembleStyle(AssembleStyle.VIPER);


    }

}