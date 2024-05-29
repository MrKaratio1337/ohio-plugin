package pl.karatiodev.plugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import pl.karatiodev.plugin.Main;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity();
        Main.getInstance().getConfig().set("deaths." + player.getName() + ".world", player.getWorld().getName());
        Main.getInstance().getConfig().set("deaths." + player.getName() + ".x", player.getLocation().getX());
        Main.getInstance().getConfig().set("deaths." + player.getName() + ".y", player.getLocation().getY());
        Main.getInstance().getConfig().set("deaths." + player.getName() + ".z", player.getLocation().getZ());
        Main.getInstance().saveConfig();
        for(int i = 1; i < 1001; i++){
            player.getWorld().spawnEntity(new Location(Bukkit.getWorld(Main.getInstance().getConfig().getString("deaths." + player.getName() + ".world")),
                    Main.getInstance().getConfig().getDouble("deaths." + player.getName() + ".x"),
                    Main.getInstance().getConfig().getDouble("deaths." + player.getName() + ".y"),
                    Main.getInstance().getConfig().getDouble("deaths." + player.getName() + ".z")),
                    EntityType.BEE);
        }
    }
}
