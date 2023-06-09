package app.controllers;

import app.entities.Order;
import app.models.AllOrdersModel;
import app.views.AllOrdersView;

import java.util.List;

public class AllOrdersController {
    private AllOrdersView view;
    private AllOrdersModel model;
    private List<Order> orders;

    public void handleData() {
        view = new AllOrdersView();
        model = new AllOrdersModel();
        orders = model.fetchAllOrders();
        view.printOrders(orders);
    }
}
