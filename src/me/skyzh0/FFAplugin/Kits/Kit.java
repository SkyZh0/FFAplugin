package me.skyzh0.FFAplugin.Kits;


import me.skyzh0.FFAplugin.Kits.kitList.*;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Kit implements Listener {
    protected static final Random random;
    public static List<Kit> kits;
    private static List<String> disabled;

    static {
        random = new Random();
        Kit.kits = new ArrayList<Kit>();
        Kit.disabled = new ArrayList<String>();
    }

    public static void init() {


        registerKit(new Archer());
        registerKit(new Base());
        registerKit(new Gapple());
        registerKit(new NoDebuff());
        registerKit(new Axe());


    }

    public static void registerKit(final Kit kit) {
        Kit.kits.add(kit);
    }

    public static Kit getKitFromName(final String kit) {
        for (final Kit k : Kit.kits) {
            if (k.getKitName().equalsIgnoreCase(kit)) {
                return k;
            }
        }
        return null;
    }

    public abstract String getKitName();


    private ItemStack getFromDetails(final ItemStack item) {
        final ItemMeta im = item.getItemMeta();
        im.setDisplayName(this.getKitName());
        item.setItemMeta(im);
        return item;
    }


    protected static ItemStack createItem(final Material mat, final String name, final boolean droppable) {
        final ItemStack is = new ItemStack(mat);
        final ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        is.setItemMeta(im);
        return is;
    }

    protected static List<String> getNewStringList() {
        return new ArrayList<String>();
    }
}
