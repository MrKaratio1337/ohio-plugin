package pl.karatiodev.plugin.listeners;

import org.bukkit.Material;
import org.bukkit.block.data.type.Snow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_AIR){
            if(player.getInventory().getItemInMainHand().getType() == Material.NETHERITE_HOE){
                player.launchProjectile(Snowball.class);
            }
        }
    }
}
