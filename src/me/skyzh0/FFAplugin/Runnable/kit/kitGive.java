package me.skyzh0.FFAplugin.Runnable.kit;

import me.skyzh0.FFAplugin.Commands.ffa.joinFfaCommand;
import me.skyzh0.FFAplugin.GUI.kitsUI.kitsUI;
import me.skyzh0.FFAplugin.Kits.kitList.Archer;
import me.skyzh0.FFAplugin.Kits.kitList.Base;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class kitGive extends BukkitRunnable {

    Player p;

    public kitGive(Player player) {
        p = player;
    }


    @Override
    public void run() {
        if (joinFfaCommand.playing.size() >= 2) {
            for (Player playing : joinFfaCommand.playing) {

                playing.getInventory().clear();

                if (kitsUI.choosenKIT == "Archer") {
                    playing.getInventory().setContents(Archer.getItems());
                    playing.getInventory().setArmorContents(Archer.getArmor());
                } else if (kitsUI.choosenKIT == "Base") {
                    playing.getInventory().setContents(Base.getItems());
                    playing.getInventory().setArmorContents(Base.getArmor());
                } else {
                    playing.getInventory().setContents(Base.getItems());
                    playing.getInventory().setArmorContents(Base.getArmor());
                }

                playing.updateInventory();

            }


        }
    }
}

