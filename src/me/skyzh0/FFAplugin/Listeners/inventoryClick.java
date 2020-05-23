package me.skyzh0.FFAplugin.Listeners;

import me.skyzh0.FFAplugin.Main;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class inventoryClick implements Listener {
    private Main plugin;

    public inventoryClick(Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        String title = e.getInventory().getName();
        Player p = (Player) e.getWhoClicked();
        if (title.equals(this.plugin.getSpecUI().inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            this.plugin.getSpecUI().clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals(this.plugin.getKitsUI().inventory_name)) {
            e.setCancelled(true);
            if (e.getCurrentItem() == null) {
                return;
            }
            this.plugin.getKitsUI().clicked((Player) e.getWhoClicked(), e.getSlot(), e.getCurrentItem(), e.getInventory());
        }
        if (title.equals("container.inventory")) {
            if (HOSTjoining.isGameRunning) {
                e.setCancelled(true);
            }
        }
        if (deathEvent.diedPlayer.contains(p)) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerClicks(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
            if (player.getItemInHand().getType() == Material.COMPASS) {
                if (deathEvent.diedPlayer.contains(player)) {
                    player.openInventory(this.plugin.getSpecUI().GUI(player));
                }
            }
        }

    }
}
