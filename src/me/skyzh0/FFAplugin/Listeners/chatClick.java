package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class chatClick implements Listener {
    private static Main plugin;

    public chatClick(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onChatClick() {

    }
}
