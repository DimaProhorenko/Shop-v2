package app.base;

import app.database.DBConn;
import app.entities.Order;
import app.utils.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface BaseModel {

    double getOrderCost(int quota, double price);

    default String addOrderToDB(Order order) {
        String sql = "INSERT INTO " + Constants.TABLE_ORDERS + " (number, quantity, price, delivery, total) VALUES(?, ?, ?, ?, ?)";
        try (Connection connection = DBConn.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, order.number());
            pstmt.setInt(2, order.quanity());
            pstmt.setDouble(3, order.price());
            pstmt.setDouble(4, order.delivery());
            pstmt.setDouble(5, order.total());
            pstmt.executeUpdate();
            return Constants.ORDER_ADDED_MSG.formatted(order.number());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Constants.ORDER_NOT_ADD_MSG;
        }
    }

}
