package me.skyzh0.FFAplugin.Runnable.spec;

import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.Listeners.deathEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class specMod extends BukkitRunnable {
    Player p;
    public static boolean isSpectating = false;

    public specMod(Player player) {
        p = player;
    }

    int counter = joinFfaCommand.playing.size();

    @Override
    public void run() {

        p.getInventory().clear();

        ItemStack SpectateTool = new ItemStack(Material.COMPASS, 1);
        ItemMeta SpectateToolMeta = SpectateTool.getItemMeta();
        SpectateToolMeta.setDisplayName("§6Spectate Tool");
        SpectateTool.setItemMeta(SpectateToolMeta);

        p.getInventory().addItem(SpectateTool);
        p.updateInventory();

        p.removePotionEffect(PotionEffectType.SPEED);
        p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

        TextComponent begin = new TextComponent("§7You entered in spectator mod, do /ffaleave to leave the event");
        TextComponent indication = new TextComponent("§aDo /spectate or use the " + ChatColor.GOLD + "Spectate tool" + ChatColor.RED + " to open the spectate gui !");
        TextComponent indication2 = new TextComponent("§a----> You can sneak + left click on a player to see his inventory !");

        p.teleport(deathEvent.deathloc);

        p.getWorld().strikeLightningEffect(p.getLocation());

        p.spigot().sendMessage(begin);
        p.spigot().sendMessage(indication);
        p.spigot().sendMessage(indication2);

        p.setGameMode(GameMode.SURVIVAL);

        p.setAllowFlight(true);
        p.setCanPickupItems(false);

        specMod.isSpectating = true;

    }
}
