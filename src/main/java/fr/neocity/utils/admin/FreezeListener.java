package fr.neocity.utils.admin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static fr.neocity.utils.admin.AdminCommands.freezeList;

public class FreezeListener implements Listener {
    @EventHandler
    private void OnFreezePlayerMove (PlayerMoveEvent e) {
        Player target = e.getPlayer();
        if (freezeList.containsKey(target.getUniqueId())) e.setCancelled(true);
    }

    @EventHandler
    private void OnFreezePlayerQuit (PlayerQuitEvent e){
        Player target = e.getPlayer();
        if (freezeList.containsKey(target.getUniqueId())) {
            target.banPlayer("déconnection durant un freeze");
            freezeList.remove(target.getUniqueId());
        }
    }
}
