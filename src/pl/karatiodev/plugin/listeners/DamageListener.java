package pl.karatiodev.plugin.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DamageListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        Player player = (Player) event.getEntity();
        if(event.getDamager() instanceof Player){
            player.sendTitle("Eustachy ssie", "", 30, 60, 30);
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if(event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION){
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 90, 90));
                player.teleport(new Location(player.getWorld(),
                        player.getLocation().getX(),
                        player.getLocation().getY() + 100,
                        player.getLocation().getZ()));
            }
        }
    }
}
