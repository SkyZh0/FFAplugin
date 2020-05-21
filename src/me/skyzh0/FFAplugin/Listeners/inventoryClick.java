package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class inventoryClick implements Listener {
    private Main plugin;

    public inventoryClick(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getName();
        if (title.equals(this.plugin.getSpecUI().inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            this.plugin.getSpecUI().clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals("container.inventory")) {
            if (HOSTjoining.isGameRunning) {
                e.setCancelled(true);
            }
        }
    }
}
