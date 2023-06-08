package app.views;

import java.util.Scanner;

public class FindOrderView {
    public int getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter order number: ");
        int orderNum = scanner.nextInt();
        scanner.nextLine();
        return orderNum;
    }

    public void getOutput(String output) {
        System.out.println(output);
        System.out.println();
    }
}
