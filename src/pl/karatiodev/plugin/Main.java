package pl.karatiodev.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.karatiodev.plugin.commands.FreeItemsCommand;
import pl.karatiodev.plugin.listeners.*;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable(){
        instance = this;
        saveDefaultConfig();
        registerListeners();
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
