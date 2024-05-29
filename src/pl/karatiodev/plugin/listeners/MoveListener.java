package pl.karatiodev.plugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        if(location.getY() < -20){
            player.damage(1000);
        }
        player.getEyeLocation().getDirection().multiply(-1);
    }
}
