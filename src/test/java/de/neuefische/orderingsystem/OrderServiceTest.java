package de.neuefische.orderingsystem;

import de.neuefische.orderingsystem.order.Order;
import de.neuefische.orderingsystem.order.OrderDb;
import de.neuefische.orderingsystem.product.Product;
import de.neuefische.orderingsystem.product.ProductDb;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    public void testAddOrder(){
        //Given
        OrderService testOrderService = new OrderService(getProductDb(), getOrderDb());
        Order expectedOrder = new Order("200", new Product[]{getProductDb().getProduct("100")});

        // When
        testOrderService.addOrder("200", new String[]{"100"});

        // Then
        assertTrue(testOrderService.getOrderDb().listOrders().contains(expectedOrder));

    }

    @Test
    public void testListOrders(){
        //Given
        OrderService testOrderService = new OrderService(getProductDb(), getOrderDb());
        ArrayList<Order> expectedOrderList = new ArrayList<Order>(List.of(
                new Order("100", new Product[]{getProductDb().getProduct("100"), getProductDb().getProduct("101")}),
                new Order("101", new Product[]{getProductDb().getProduct("102"), getProductDb().getProduct("103")}),
                new Order("102", new Product[]{getProductDb().getProduct("104")})
        ));

        // When
        ArrayList<Order> actualOrderList = testOrderService.listOrders();

        // Then
        assertTrue(expectedOrderList.size() == actualOrderList.size());
        assertTrue(expectedOrderList.containsAll(actualOrderList));
        assertTrue(actualOrderList.containsAll(expectedOrderList));
    }

    @Test
    public void testListProducts(){
        //Given
        OrderService testOrderService = new OrderService(getProductDb(), getOrderDb());
        ArrayList<Product> expectedProductList = new ArrayList<Product>(List.of(
                new Product("100", "Dress"),
                new Product("101", "Jeans"),
                new Product("102", "Tshirt"),
                new Product("103", "Hoodie"),
                new Product("104", "Socks")
        ));

        // When
        ArrayList<Product> actualProductList = testOrderService.listProducts();

        // Then
        assertEquals(expectedProductList, actualProductList);
    }

    private static OrderDb getOrderDb(){

        HashMap<String, Order> testOrderHashMap = new HashMap<String, Order>(){{
            put("1000", new Order("100", new Product[]{getProductDb().getProduct("100"), getProductDb().getProduct("101")}));
            put("1001", new Order("101", new Product[]{getProductDb().getProduct("102"), getProductDb().getProduct("103")}));
            put("1002", new Order("102", new Product[]{getProductDb().getProduct("104")}));
        }};

        return new OrderDb(testOrderHashMap);

    }

    private static ProductDb getProductDb() {
        ArrayList<Product> testProducts = new ArrayList<Product>(List.of(
                new Product("100", "Dress"),
                new Product("101", "Jeans"),
                new Product("102", "Tshirt"),
                new Product("103", "Hoodie"),
                new Product("104", "Socks")
        ));

        return new ProductDb(testProducts);
    }

}