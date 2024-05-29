package pl.karatiodev.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        Player player = (Player) event.getEntity();
        if(event.getDamager() instanceof Player){
            player.sendTitle("Eustachy ssie", "", 30, 60, 30);
        }
    }
}
