package com.auction.dao;

import com.auction.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuctionDAO {

    public synchronized boolean placeBid(int userId, int itemId, double bidAmount) {
        boolean isSuccess = false;
        String checkQuery = "SELECT MAX(bid_amount) FROM Bids WHERE item_id = ?";
        String insertQuery = "INSERT INTO Bids (user_id, item_id, bid_amount) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setInt(1, itemId);
            ResultSet rs = checkStmt.executeQuery();

            double currentMax = 0;
            if (rs.next()) {
                currentMax = rs.getDouble(1);
            }

            if (bidAmount > currentMax) {
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, itemId);
                insertStmt.setDouble(3, bidAmount);

                int rows = insertStmt.executeUpdate();
                if (rows > 0) {
                    isSuccess = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
