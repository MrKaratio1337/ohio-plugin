package pl.karatiodev.plugin.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import java.util.Random;

public class MoveListener implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();

        if(location.getY() < -20){
            player.damage(1000);
        }

        player.getEyeLocation().getDirection().multiply(-1);

        Material[] materials = Material.values();
        Random random = new Random();
        Material randomBlock = materials[random.nextInt(materials.length)];
        player.getLocation().subtract(0, 1, 0).getBlock().setType(randomBlock);

        if(player.getEyeLocation().getBlock().getType() == Material.OAK_LOG){
            player.getEyeLocation().getBlock().setType(Material.COBBLESTONE);
        }
        
        Vector direction = player.getLocation().getDirection();
        World world = player.getWorld();
        for(Entity entity : player.getNearbyEntities(50, 50, 50)){
            if(entity instanceof EnderDragon){
                Vector toEntity = entity.getLocation().toVector().subtract(player.getLocation().toVector()).normalize();
                if(direction.dot(toEntity) > 0.99){
                    Location spawnLocation = player.getLocation().add(player.getLocation().getDirection().multiply(10));
                    world.spawn(spawnLocation, EnderDragon.class);
                    break;
                }
            }
        }
    }
}
