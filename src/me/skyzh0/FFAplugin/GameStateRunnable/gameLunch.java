package me.skyzh0.FFAplugin.GameStateRunnable;

import me.skyzh0.FFAplugin.Listeners.deathEvent;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;
import me.skyzh0.FFAplugin.Commands.joinFfaCommand;

import java.util.Collection;

public class gameLunch extends BukkitRunnable {
    Player p;
    int spawnPointX = 0;
    int spawnPointY = 83;
    int spawnPointZ = 0;
    Location arena1 = new Location(Bukkit.getWorld("world"), spawnPointX, spawnPointY, spawnPointZ);

    public gameLunch(Player player) {
        p = player;
    }

    @Override
    public void run() {
        int i = 0;
        if (!(joinFfaCommand.playing.size() >= 2)) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!(joinFfaCommand.playing.contains(player))) {
                    Bukkit.broadcastMessage("LOL");
                }
                i++;
            }
            cancel();
        } else {
            int j = 0;
            for (Player playing : Bukkit.getOnlinePlayers()){
                playing.setFlying(false);
                playing.setAllowFlight(false);
                j ++;
            }
            p.teleport(arena1);
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 5 * 20, 255));
            p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 5 * 20, 255));
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents(new ItemStack[4]);
            p.getInventory().clear();
            p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            ItemStack SWORD = new ItemStack(Material.STONE_SWORD);
            ItemMeta meta = SWORD.getItemMeta();
            meta.addEnchant(Enchantment.DURABILITY, 3, true);
            meta.setDisplayName(ChatColor.DARK_GRAY + "Master FFA Sword");
            SWORD.setItemMeta(meta);

            p.getInventory().setItem(0, SWORD);
            p.updateInventory();
            p.setHealth(p.getMaxHealth());
            p.setFoodLevel(20);
            p.setExp(0);
            p.setLevel(0);
        }
    }
}
