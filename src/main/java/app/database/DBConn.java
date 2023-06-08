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

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Order findOrder(int orderNumber) {
        String sql = "SELECT number, quantity, price, delivery, total FROM " + Constants.TABLE_ORDERS + " WHERE number = ?";
        Order order = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
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

