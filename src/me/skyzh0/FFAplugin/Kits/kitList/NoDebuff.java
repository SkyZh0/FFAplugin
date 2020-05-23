package me.skyzh0.FFAplugin.Kits.kitList;

import me.skyzh0.FFAplugin.Kits.Kit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class NoDebuff extends Kit {
    @Override
    public String getKitName() {
        return "NoDebuff";
    }

    public static ItemStack[] getItems() {

        final ItemStack sword = new ItemStack(Material.DIAMOND_SWORD, 1);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        sword.addEnchantment(Enchantment.DURABILITY, 3);
        sword.addEnchantment(Enchantment.FIRE_ASPECT, 2);

        final Potion fireREZ;
        final Potion speedPOT;
        final Potion Heal;

        fireREZ = (Potion) new Potion(PotionType.FIRE_RESISTANCE);
        fireREZ.setHasExtendedDuration(true);


        speedPOT = (Potion) new Potion(PotionType.SPEED);
        speedPOT.setLevel(2);
        speedPOT.setHasExtendedDuration(false);

        Heal = (Potion) new Potion(PotionType.INSTANT_HEAL);
        Heal.setLevel(2);
        Heal.setSplash(true);


        final ItemStack enderpearls = new ItemStack(Material.ENDER_PEARL, 16);
        final ItemStack bouffe = new ItemStack(Material.GOLDEN_CARROT, 64);


        final ItemStack[] items = {sword, enderpearls, speedPOT.toItemStack(1), fireREZ.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), bouffe,
                Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1),
                Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1),
                Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1), Heal.toItemStack(1),
                speedPOT.toItemStack(1), speedPOT.toItemStack(1)};

        return items;
    }

    public static ItemStack[] getArmor() {

        final ItemStack[] armor = new ItemStack[4];
        armor[0] = new ItemStack(Material.DIAMOND_BOOTS, 1);
        armor[0].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        armor[0].addEnchantment(Enchantment.DURABILITY, 3);

        armor[1] = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        armor[1].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        armor[1].addEnchantment(Enchantment.DURABILITY, 3);

        armor[2] = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        armor[2].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        armor[2].addEnchantment(Enchantment.DURABILITY, 3);

        armor[3] = new ItemStack(Material.DIAMOND_HELMET, 1);
        armor[3].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
        armor[3].addEnchantment(Enchantment.DURABILITY, 3);

        return armor;
    }

    public static ItemStack icon() {

        Potion iconPotion = new Potion(PotionType.INSTANT_HEAL);
        iconPotion.setLevel(2);
        iconPotion.setSplash(true);

        final ItemStack icon = iconPotion.toItemStack(1);


        ItemMeta iconMeta = icon.getItemMeta();

        iconMeta.setDisplayName("NoDebuff");

        icon.setItemMeta(iconMeta);


        return icon;
    }


}
