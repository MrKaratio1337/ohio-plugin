package pl.karatiodev.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import pl.karatiodev.plugin.Main;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 2147483647, 5));
        if(player.getName().equalsIgnoreCase("Przemo124")){
            player.damage(1000);
        }
    }
}
