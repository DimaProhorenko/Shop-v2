package app;


import app.controllers.FindOrderController;
import app.database.DBConn;
import app.controllers.OrderAController;
import app.controllers.OrderBController;
import app.entities.Order;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
        Connection connection = DBConn.connect();
        DBConn.createShopTable();
        int choice = 0;
        do {
            choice = filterOption(getOption());
        } while (choice != 0);

    }

    private static int getOption() {
        System.out.println("""
                Choose an option:
                1 - order without delivery
                2 - order with delivery
                3 - view order by  order number
                0 - quit
                """);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int filterOption(int option) {
        switch (option) {
            case 1 -> {
                OrderAController controller = new OrderAController();
                controller.handleData();
            }
            case 2 -> {
                OrderBController controller = new OrderBController();
                controller.handleData();
            }
            case 3 -> {
                FindOrderController controller = new FindOrderController();
                controller.handleData();
            }
        }
        return option;
    }
}
