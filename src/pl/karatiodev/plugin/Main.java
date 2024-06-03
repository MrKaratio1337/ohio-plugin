package pl.karatiodev.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import pl.karatiodev.plugin.commands.FreeItemsCommand;
import pl.karatiodev.plugin.listeners.*;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable(){
        instance = this;
        saveDefaultConfig();
        registerListeners();
        new BukkitRunnable(){
            public void run(){
                for(Player player : Bukkit.getOnlinePlayers()) player.playSound(player.getLocation(), Sound.AMBIENT_CAVE, 1.0f, 1.0f);
            }
        }.runTaskTimer(Main.getInstance(), 20L * 120, 20L * 120);
    }

    private void registerCommands(){
        this.getCommand("freeitemy").setExecutor(new FreeItemsCommand());
    }

    private void registerListeners(){
        final PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BreakListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new DamageListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new SpawnListener(), this);
        pluginManager.registerEvents(new InteractListener(), this);
    }

    public static Main getInstance() {
        return instance;
    }
}
