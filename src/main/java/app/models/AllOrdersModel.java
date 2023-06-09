package app.models;

import app.database.DBConn;
import app.entities.Order;
import app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllOrdersModel {

    public List<Order> fetchAllOrders() {
        List<Order> orders = null;
        String sql = "SELECT * FROM " + Constants.TABLE_ORDERS;
        try (Connection connection = DBConn.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet results = pstmt.executeQuery()) {
            orders = new ArrayList<>();
            while (results.next()) {
                Order order = new Order(
                        results.getInt("number"),
                        results.getInt("quantity"),
                        results.getDouble("price"),
                        results.getDouble("delivery"),
                        results.getDouble("total")
                );
                orders.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return orders;
    }
}
