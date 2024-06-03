package pl.karatiodev.plugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent event){
        if(event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL){
            Player player = event.getPlayer();
            Location targetLocation = new Location(player.getWorld(), 100, 64, 100);
            player.teleport(targetLocation);
            event.setCancelled(true);
        }
    }
}
