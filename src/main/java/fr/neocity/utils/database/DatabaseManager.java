package fr.neocity.utils.database;

import fr.neocity.NeoCity;
import fr.neocity.utils.rank.RankManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public DatabaseManager () {
        connect();
        try{
            RankManager.init_db(connection);
        }catch (Exception e){
            e.printStackTrace();
            NeoCity.getInstance().getLogger().severe("Impossible d'initialiser la base de données");
        }
    }

    private static void connect () {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            FileConfiguration config = NeoCity.getConfigs();

            if (!(config.contains("database.url") || config.contains("database.username") || config.contains("database.password"))) {
                NeoCity.getInstance().getLogger().severe("Impossible de se connecter à la base de données");
                Bukkit.getPluginManager().disablePlugin(NeoCity.getInstance());
            }
            connection = DriverManager.getConnection(
                    config.getString("database.url"),
                    config.getString("database.username"),
                    config.getString("database.password")
            );
            NeoCity.getInstance().getLogger().info("\u001B[32m" + "Connexion à la base de données réussie\u001B[0m");
        } catch (SQLException | ClassNotFoundException e) {
            NeoCity.getInstance().getLogger().warning("\u001B[31m" + "Connexion à la base de données échouée\u001B[0m");
            throw new RuntimeException(e);
        }
    }
    public void close() throws SQLException {
        if (connection != null) {
            if (!connection.isClosed()) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static Connection getConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    return connection;
                }
            } catch (SQLException e) {
                connect();
                return connection;
            }
        }
        connect();
        return connection;
    }
}
