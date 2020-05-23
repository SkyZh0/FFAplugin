package me.skyzh0.FFAplugin.Kits.kitList;

import me.skyzh0.FFAplugin.Kits.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class Axe extends Kit {
    @Override
    public String getKitName() {
        return "Axe";
    }

    public static ItemStack[] getItems() {

        final ItemStack sword = new ItemStack(Material.IRON_AXE, 1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);


        final Potion speedPOT;
        final Potion Heal;


        speedPOT = (Potion) new Potion(PotionType.SPEED);
        speedPOT.setLevel(2);
        speedPOT.setHasExtendedDuration(false);

        Heal = (Potion) new Potion(PotionType.INSTANT_HEAL);
        Heal.setLevel(2);
        Heal.setSplash(true);

        final ItemStack gap = new ItemStack(Material.GOLDEN_APPLE, 16);

        final ItemStack[] items = {sword, speedPOT.toItemStack(1), gap,
                Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1),
                speedPOT.toItemStack(1)};

        return items;
    }

    public static ItemStack[] getArmor() {

        final ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.IRON_BOOTS, 1);

        armor[1] = new ItemStack(Material.IRON_LEGGINGS, 1);

        armor[2] = new ItemStack(Material.IRON_CHESTPLATE, 1);

        armor[3] = new ItemStack(Material.IRON_HELMET, 1);

        return armor;
    }

    public static ItemStack icon() {

        final ItemStack icon = new ItemStack(Material.IRON_AXE, 1);


        ItemMeta iconMeta = icon.getItemMeta();

        iconMeta.setDisplayName("Axe");

        icon.setItemMeta(iconMeta);


        return icon;
    }


}
