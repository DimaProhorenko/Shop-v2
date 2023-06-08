package app;

import app.controllers.OrderAController;
import app.controllers.OrderBController;

import java.util.Scanner;

public class Main {

    static Scanner scanner;

    public static void main(String[] args) {
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
        }
        return option;
    }
}
