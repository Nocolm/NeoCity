package fr.neocity;

import dev.xernas.menulib.MenuLib;
import fr.neocity.utils.CommandManager;
import fr.neocity.utils.NeoCityManager;
import fr.neocity.utils.database.DatabaseManager;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class NeoCity extends JavaPlugin {
    @Getter static NeoCity instance;
    @Getter static FileConfiguration configs;
    private DatabaseManager dbManager;

    @Override
    public void onEnable() {
        instance = this;

        /* Config */
        saveDefaultConfig();
        configs = this.getConfig();

        /* Manager */
        dbManager = new DatabaseManager();
        MenuLib.init(this);
        new CommandManager();
        new NeoCityManager();
        getLogger().info("Plugin Activer");

    }

    @Override
    public void onDisable() {
        if (dbManager != null) {
            try {
                dbManager.close();
            } catch (SQLException e) {
                getLogger().severe("Impossible de fermer la connexion à la base de données");
            }
        }

        getLogger().info("Plugin désactivé");
    }

    public static void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            instance.getServer().getPluginManager().registerEvents(listener, instance);
        }
    }
}
