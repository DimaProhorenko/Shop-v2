package app.views;

import app.entities.Order;

import java.util.List;

public class AllOrdersView {

    public void printOrders(List<Order> orders) {
        orders.forEach(System.out::println);
    }
}
