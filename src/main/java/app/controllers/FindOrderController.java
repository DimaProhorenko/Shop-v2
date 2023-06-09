package app.controllers;

import app.database.DBConn;
import app.entities.Order;
import app.models.FindOrderModel;
import app.utils.Constants;
import app.views.FindOrderView;
import org.sqlite.core.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindOrderController {
    private FindOrderView view;
    private FindOrderModel model;
    private int orderNum;
    private Order order;

    public void handleData() {
        view = new FindOrderView();
        model = new FindOrderModel();
        orderNum = view.getData();
        order = model.findOrder(orderNum);
        view.getOutput(createOutput());
    }

    private String createOutput() {
        if (order != null) {
            return order.toString();
        }
        return "Order #%d not found".formatted(orderNum);
    }
}
