package me.skyzh0.FFAplugin.specUI;

import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class specUI {
    Player p;

    public specUI(Player player) {
        p = player;
    }

    public Inventory inv;
    public String inventory_name;
    public int inv_rows = 5 * 9;

    public specUI() {
        inventory_name = "§6§lSpectator Mode";
        inv = Bukkit.createInventory(null, inv_rows);
    }

    public Inventory GUI(Player p) {
        Inventory toReturn = Bukkit.createInventory(null, inv_rows, inventory_name);

        int slot = 0;
        for (Player playing : joinFfaCommand.playing) {
            ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());

            SkullMeta meta = (SkullMeta) skull.getItemMeta();
            meta.setOwner(playing.getName());
            meta.setDisplayName(playing.getName());
            skull.setItemMeta(meta);

            toReturn.setItem(slot, skull);

            slot++;
        }
        return toReturn;
    }

    public void clicked(Player p, int slot, ItemStack clicked, Inventory inv) {
        if (clicked.getType() == Material.SKULL_ITEM) {

            String toSpec = clicked.getItemMeta().getDisplayName();
            Player toSpecPlayer = Bukkit.getServer().getPlayer(toSpec);
            Location toSpecLocation = toSpecPlayer.getLocation();

            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2, 255));

            p.teleport(toSpecLocation);
            p.closeInventory();
        }
    }
}

