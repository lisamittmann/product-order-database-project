package de.neuefische.orderingsystem.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class OrderDb {

    private HashMap<String, Order> orderList;

    public OrderDb(HashMap<String, Order> orderList) {
        this.orderList = orderList;
    }

    public ArrayList<Order> listOrders() {
        ArrayList<Order> orderArrayList = new ArrayList<Order>();

        this.orderList.forEach((k, v) -> {
            orderArrayList.add(v);
        });

        return orderArrayList;
    }

    public Optional<Order> getOrder(String id) {
        if(this.orderList.containsKey(id)) {
            return Optional.of(this.orderList.get(id));
        } else {
            return Optional.empty();
        }
    }

    public void addOrder(Order order){
        String orderKey = generateKey();
        this.orderList.put(orderKey, order);
        System.out.println("The order with id " + orderKey + " has been added");
    }

    private String generateKey() {

        String key = String.valueOf((int)(Math.random()*10000));

        if(!this.orderList.containsKey(key)) {
            return key;
        } else {
            generateKey();
        }
        return null;
    }
}
