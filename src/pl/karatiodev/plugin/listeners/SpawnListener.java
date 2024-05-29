package pl.karatiodev.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import pl.karatiodev.plugin.Main;

public class SpawnListener implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        Chicken chicken = (Chicken) event.getLocation().getWorld().spawnEntity(event.getLocation(), EntityType.CHICKEN);

        chicken.setAI(true);
        chicken.setLoveModeTicks(10000);
        chicken.setCustomName("Kurczak Bombowy");

        Attributable chickenAt = chicken;
        AttributeInstance attribute = chickenAt.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        attribute.setBaseValue(10000);
        chicken.setHealth(10000);

        Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                chicken.getLocation().getWorld().spawnEntity(chicken.getLocation(), EntityType.PRIMED_TNT);
            }
        }, 0L, 20L);
    }

}
