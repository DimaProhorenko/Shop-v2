package app.controllers;

import app.database.DBConn;
import app.entities.Order;
import app.views.FindOrderView;

public class FindOrderController {
    private FindOrderView view;
    private int orderNum;
    private Order order;

    public void handleData() {
        view = new FindOrderView();
        orderNum = view.getData();
        order = DBConn.findOrder(orderNum);
        view.getOutput(createOutput());
    }

    private String createOutput() {
        if (order != null) {
            return order.toString();
        }
        return "Order #%d not found".formatted(orderNum);
    }
}
