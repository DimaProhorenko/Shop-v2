package app.utils;

public final class Constants {

    public final static String CURRENCY = "USD";
    public final static double DELIVERY_RATE = 2.5;

    public static final String DB_DRIVER = "jdbc:sqlite:";
    public static final String DB_BASE_URL = "src/main/resources/database/";
    public static final String DB_NAME = "shop_db.db";
    public static final String DB_FULL_URL = DB_DRIVER + DB_BASE_URL + DB_NAME;


    public static final String TABLE_ORDERS = "orders";
    public static final String COLUMN_ORDERS_ID = "_id";
    public static final String COLUMN_ORDERS_NUMBER = "number";
    public static final String COLUMN_ORDERS_QUANITTY = "quantity";
    public static final String COLUMN_ORDERS_PRICE = "price";
    public static final String COLUMN_ORDERS_DELIVERY = "delivery";
    public static final String COLUMN_ORDERS_TOTAL = "total";
    public static final String CREATE_ORDERS_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS orders (_id INTEGER PRIMARY KEY, number INTEGER, quantity INTEGER, price REAL, delivery REAL, total REAL)";
}
