package me.skyzh0.FFAplugin.Kits.kitList;

import me.skyzh0.FFAplugin.Kits.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Gapple extends Kit {
    @Override
    public String getKitName() {
        return "Gapple";
    }

    public static ItemStack[] getItems() {

        final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
        sword.addEnchantment(Enchantment.DURABILITY, 3);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);

        final ItemStack gap = new ItemStack(Material.GOLDEN_APPLE, 64, (short) 1);

        final ItemStack boots;
        final ItemStack leggings;
        final ItemStack chestplate;
        final ItemStack helmet;

        boots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        boots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        boots.addEnchantment(Enchantment.DURABILITY, 3);

        leggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        leggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        leggings.addEnchantment(Enchantment.DURABILITY, 3);

        chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        chestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        chestplate.addEnchantment(Enchantment.DURABILITY, 3);

        helmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        helmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        helmet.addEnchantment(Enchantment.DURABILITY, 3);

        final Potion forcePOT;
        final Potion speedPOT;

        forcePOT = (Potion) new Potion(PotionType.STRENGTH);
        forcePOT.setLevel(2);
        forcePOT.setHasExtendedDuration(true);


        speedPOT = (Potion) new Potion(PotionType.SPEED);
        speedPOT.setLevel(2);
        speedPOT.setHasExtendedDuration(true);


        final ItemStack[] items = {sword, gap, helmet, chestplate, leggings, boots, forcePOT.toItemStack(1), speedPOT.toItemStack(1)};

        return items;
    }

    public static ItemStack[] getArmor() {

        final ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.DIAMOND_BOOTS, 1);
        armor[0].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        armor[0].addEnchantment(Enchantment.DURABILITY, 3);

        armor[1] = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        armor[1].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        armor[1].addEnchantment(Enchantment.DURABILITY, 3);

        armor[2] = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        armor[2].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        armor[2].addEnchantment(Enchantment.DURABILITY, 3);

        armor[3] = new ItemStack(Material.DIAMOND_HELMET, 1);
        armor[3].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        armor[3].addEnchantment(Enchantment.DURABILITY, 3);

        return armor;
    }

    public static ItemStack icon() {
        final ItemStack icon = new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1);


        ItemMeta iconMeta = icon.getItemMeta();

        iconMeta.setDisplayName("Gapple");

        icon.setItemMeta(iconMeta);


        return icon;
    }


}
