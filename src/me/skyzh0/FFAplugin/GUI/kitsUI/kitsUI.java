package me.skyzh0.FFAplugin.GUI.kitsUI;

import me.skyzh0.FFAplugin.Kits.kitList.Archer;
import me.skyzh0.FFAplugin.Kits.kitList.Base;
import me.skyzh0.FFAplugin.Runnable.ffa.HOSTjoining;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class kitsUI {
    Player p;

    public kitsUI(Player player) {
        p = player;
    }

    public Inventory inv;
    public String inventory_name;
    public int inv_rows = 1 * 9;

    public kitsUI() {
        inventory_name = "§6§lKit Selector";
        inv = Bukkit.createInventory(null, inv_rows);
    }

    public Inventory GUI(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        toReturn.setItem(0, Archer.icon());
        toReturn.setItem(1, Base.icon());

        return toReturn;
    }

    public static String choosenKIT = null;

    public void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (HOSTjoining.LunchTimer >= 30) {
            if (clicked.getType().equals(Archer.icon().getType())) {
                String kitname = "Archer";
                kitsUI.choosenKIT = kitname;
                p.sendMessage("§aYou choose the " + ChatColor.GOLD + kitname + ChatColor.GREEN + " kit for your FFA event");
                p.closeInventory();
            } else if (clicked.getType().equals(Base.icon().getType())) {
                String kitname = "Base";
                kitsUI.choosenKIT = kitname;
                p.sendMessage("§aYou choose the " + ChatColor.GOLD + kitname + ChatColor.GREEN + " kit for your FFA event");
                p.closeInventory();
            }
        } else {
            p.sendMessage("§cIt's too late you will play with the default kit !");
            kitsUI.choosenKIT = "Base";
            p.closeInventory();
        }
    }
}

