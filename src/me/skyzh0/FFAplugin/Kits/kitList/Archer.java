package me.skyzh0.FFAplugin.Kits.kitList;

import me.skyzh0.FFAplugin.Kits.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Archer extends Kit {
    @Override
    public String getKitName() {
        return "Archer";
    }

    public static ItemStack[] getItems() {
        final ItemStack bow = new ItemStack(Material.BOW);
        bow.addEnchantment(Enchantment.ARROW_DAMAGE, 1);
        bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);
        final ItemStack[] items = {bow, new ItemStack(Material.ARROW, 1)};

        return items;
    }

    public static ItemStack[] getArmor() {

        final ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.LEATHER_BOOTS, 1);
        armor[1] = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        armor[2] = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        armor[3] = new ItemStack(Material.LEATHER_HELMET, 1);

        return armor;
    }

    public static ItemStack icon() {
        final ItemStack icon = new ItemStack(Material.BOW, 1);


        ItemMeta iconMeta = icon.getItemMeta();

        iconMeta.setDisplayName("Archer");

        icon.setItemMeta(iconMeta);


        return icon;
    }


}
