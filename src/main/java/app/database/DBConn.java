package app.database;
import app.entities.Order;
import app.utils.Constants;

import java.sql.*;

public class DBConn {
    private static Connection connection = null;

    public static Connection connect() {
        try {
            connection = DriverManager.getConnection(Constants.DB_FULL_URL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static boolean createShopTable() {
        try(Statement statement = connection.createStatement()) {
            statement.execute(Constants.CREATE_ORDERS_TABLE_QUERY);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void addOrder(Order order) {
        String sql = "INSERT INTO " + Constants.TABLE_ORDERS + " (number, quantity, price, delivery, total) VALUES(?, ?, ?, ?, ?)";
        try (Statement statement = connection.createStatement();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, order.number());
            pstmt.setInt(2, order.quanity());
            pstmt.setDouble(3, order.price());
            pstmt.setDouble(4, order.delivery());
            pstmt.setDouble(5, order.total());
            pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

