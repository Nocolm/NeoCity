package fr.neocity.utils.rank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class RankManager {
    static Connection conn;

    public static void init_db(Connection conn) throws SQLException {
        conn.prepareStatement("CREATE TABLE IF NOT EXISTS player_ranks (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "uuid VARCHAR(36) NOT NULL, " +
                "rank VARCHAR(50) NOT NULL, " +
                "last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP" +
                ");"
        ).executeUpdate();
        RankManager.conn = conn;
    }

    public static void addRank ( UUID uuid, String rank) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO player_ranks (uuid, rank) VALUES (?, ?) ON DUPLICATE KEY UPDATE rank = ?");
        stmt.setString(1, uuid.toString());
        stmt.setString(2, rank);
        stmt.setString(3, rank);
        stmt.executeUpdate();
    }

    public static void removeRank(UUID uuid) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM player_ranks WHERE uuid = ?");
        stmt.setString(1, uuid.toString());
        stmt.executeUpdate();
    }

    public static String getRank(UUID uuid) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT rank FROM player_ranks WHERE uuid = ?");
        stmt.setString(1, uuid.toString());
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("rank");
            }
        }
        return null;
    }
}
