package de.neuefische.orderingsystem;

import de.neuefische.orderingsystem.order.Order;
import de.neuefische.orderingsystem.order.OrderDb;
import de.neuefische.orderingsystem.product.Product;
import de.neuefische.orderingsystem.product.ProductDb;

import java.util.ArrayList;

public class OrderService {

    private ProductDb productDb;
    private OrderDb orderDb;

    public OrderService(ProductDb productDb, OrderDb orderDb) {
        this.productDb = productDb;
        this.orderDb = orderDb;
    }

    public ProductDb getProductDb() {
        return productDb;
    }

    public void setProductDb(ProductDb productDb) {
        this.productDb = productDb;
    }

    public OrderDb getOrderDb() {
        return orderDb;
    }

    public void setOrderDb(OrderDb orderDb) {
        this.orderDb = orderDb;
    }

    public void addOrder(String orderId, String[] productIds){

        Product[] orderedProducts = new Product[productIds.length];
        for (int i = 0; i < productIds.length; i++) {
            orderedProducts[i] = this.productDb.getProduct(productIds[i]);
        }

        Order newOrder = new Order(orderId,orderedProducts);
        this.orderDb.addOrder(newOrder);

    }

    public ArrayList<Order> listOrders() {
        return this.orderDb.listOrders();
    }

    public ArrayList<Product> listProducts(){
        return this.productDb.listProducts();
    }
}
