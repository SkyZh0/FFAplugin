package me.skyzh0.FFAplugin.Listeners;

import io.github.thatkawaiisam.assemble.events.AssembleBoardCreateEvent;
import net.md_5.bungee.api.plugin.Listener;
import org.bukkit.event.EventHandler;

public class AssembleSampleListeners implements Listener {

    @EventHandler
    public void onBoardCreate(AssembleBoardCreateEvent event) {
        //Do what you want with the player object
    }
}
