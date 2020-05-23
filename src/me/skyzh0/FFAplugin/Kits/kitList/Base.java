package me.skyzh0.FFAplugin.Kits.kitList;

import me.skyzh0.FFAplugin.Kits.Kit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Base extends Kit {
    @Override
    public String getKitName() {
        return "Archer";
    }

    public static ItemStack[] getItems() {

        final ItemStack sword = new ItemStack(Material.STONE_SWORD, 1);

        final ItemStack[] items = {sword};

        return items;
    }

    public static ItemStack[] getArmor() {

        final ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.AIR, 1);
        armor[1] = new ItemStack(Material.AIR, 1);
        armor[2] = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        armor[3] = new ItemStack(Material.AIR, 1);

        return armor;
    }

    public static ItemStack icon() {
        final ItemStack icon = new ItemStack(Material.STONE_SWORD, 1);


        ItemMeta iconMeta = icon.getItemMeta();

        iconMeta.setDisplayName("Base");

        icon.setItemMeta(iconMeta);


        return icon;
    }


}
