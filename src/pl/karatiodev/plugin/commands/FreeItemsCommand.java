package pl.karatiodev.plugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import pl.karatiodev.plugin.Main;

public class FreeItemsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player player = (Player) sender;
        player.getInventory().clear();
        player.sendMessage("Co ty kurwa myślałeś? Darmowe ity się chciało co?");
        new BukkitRunnable(){
            @Override
            public void run() {
                player.kickPlayer("No i kurwa chuj");
            }
        }.runTaskLater(Main.getInstance(), 150L);
        return true;
    }
}
