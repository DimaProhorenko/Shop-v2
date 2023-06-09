package app.models;

import app.database.DBConn;
import app.entities.Order;
import app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindOrderModel {

    public Order findOrder(int orderNumber) {
        String sql = "SELECT number, quantity, price, delivery, total FROM " + Constants.TABLE_ORDERS + " WHERE number = ?";
        Order order = null;
        try (Connection conn = DBConn.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderNumber);
            ResultSet results = pstmt.executeQuery();
            order = new Order(
                    results.getInt(Constants.COLUMN_ORDERS_NUMBER),
                    results.getInt(Constants.COLUMN_ORDERS_QUANITTY),
                    results.getDouble(Constants.COLUMN_ORDERS_PRICE),
                    results.getDouble(Constants.COLUMN_ORDERS_DELIVERY),
                    results.getDouble(Constants.COLUMN_ORDERS_TOTAL)
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return order;
    }
}
