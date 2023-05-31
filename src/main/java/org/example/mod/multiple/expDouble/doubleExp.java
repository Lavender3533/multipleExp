package org.example.mod.multiple.expDouble;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.example.mod.multiple.multiple;
import org.example.mod.multiple.util.MyC;

public class doubleExp implements Listener {
    int[] times = new int[3];

    @EventHandler
    public void playerExp(PlayerExpChangeEvent expEvent) {
//        times[0] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple");
//        times[1] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple1");
//        times[2] = multiple.expmain.getConfig().getInt("ExpMagnification.multiple2");
        //Obtaining Players
        System.arraycopy(MyC.U, 0, times, 0, times.length);
        Player player = expEvent.getPlayer();
        //Obtain player experience events
        int playerExp = expEvent.getAmount();
        //Determine if the player's permissions have permission&&is in survival mode
        if (player.hasPermission("Exp.multiple.1") && player.getGameMode() == GameMode.SURVIVAL) {
            int inPlayerExp = playerExp * times[0];
            expEvent.setAmount(Math.round(inPlayerExp));
        }
        //Determine if the player has Exp permission
        if (player.hasPermission("Exp.multiple.2") && player.getGameMode() == GameMode.SURVIVAL) {
            int inPlayerExp2 = playerExp * times[1];
            expEvent.setAmount(Math.round(inPlayerExp2));
        }
        //Modify the magnification through the config file and use the command to open/Exp openactivity
        if (multiple.activity && player.hasPermission("Exp.multiple.3")) {
            int Openactivity = playerExp * times[2];
            expEvent.setAmount(Math.round(Openactivity));
        }


    }
}
