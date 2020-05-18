package me.skyzh0.FFAplugin;

/**
 * Created by SkyZh0 on the 18/05/2020
 */

import me.skyzh0.FFAplugin.Commands.ffaAdminCommand;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.lunchFfaCommand;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        new lunchFfaCommand(this);
        new joinFfaCommand(this);
        new ffaAdminCommand(this);

    }
}
