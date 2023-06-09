package app.controllers;

import app.base.BaseController;
import app.models.OrderAModel;
import app.utils.Constants;
import app.utils.Rounder;
import app.views.OrderView;
import app.entities.Order;

public class OrderAController implements BaseController{

    private OrderView view;
    private OrderAModel model;
    private String[] data;
    private String costRounded;
    private String orderAddingResult;

    @Override
    public void handleData() {
        view = new OrderView();
        data = getData();
        model = new OrderAModel();
        double cost = getOrderCost();
        costRounded = Rounder.roundValue(cost);
        view.getOutput(formOutput());
        orderAddingResult = model.addOrderToDB(new Order(Integer.parseInt(data[0]), Integer.parseInt(data[1]),
                Double.parseDouble(data[2]), 0, cost));
    }

    private String[] getData() {
        return view.getData();
    }

    private double getOrderCost() {
        return model.getOrderCost(Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
    }

    private String formOutput() {
        return orderAddingResult + "\nOrder " + data[0] + " cost is " + Constants.CURRENCY +
                " " + costRounded;
    }
}
