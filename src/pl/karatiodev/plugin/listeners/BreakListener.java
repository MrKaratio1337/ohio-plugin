package pl.karatiodev.plugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        player.damage(1000);
    }
}
