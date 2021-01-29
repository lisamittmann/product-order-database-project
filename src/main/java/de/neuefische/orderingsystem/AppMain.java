package de.neuefische.orderingsystem;

import de.neuefische.orderingsystem.order.Order;
import de.neuefische.orderingsystem.order.OrderDb;
import de.neuefische.orderingsystem.product.Product;
import de.neuefische.orderingsystem.product.ProductDb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {

        OrderService orderService = new OrderService(getProductDb(), getOrderDb());

        System.out.println(orderService.listProducts());

        System.out.println(orderService.listOrders());


    }

    private static OrderDb getOrderDb(){

        HashMap<String, Order> testOrderHashMap = new HashMap<String, Order>(){{
            put("1000", new Order("100", new Product[]{getProductDb().getProduct("100").get(), getProductDb().getProduct("101").get()}));
            put("1001", new Order("101", new Product[]{getProductDb().getProduct("102").get(), getProductDb().getProduct("103").get()}));
            put("1002", new Order("102", new Product[]{getProductDb().getProduct("104").get()}));
        }};

        return new OrderDb(testOrderHashMap);

    }

    private static ProductDb getProductDb(){
        return new ProductDb(new ArrayList<Product>(List.of(
                new Product("100", "Dress"),
                new Product("101", "Jeans"),
                new Product("102", "Tshirt"),
                new Product("103", "Hoodie"),
                new Product("104", "Socks")
        )));
    }
}
