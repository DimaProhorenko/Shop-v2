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
}

