package de.neuefische.orderingsystem.order;

import de.neuefische.orderingsystem.product.Clothing;
import de.neuefische.orderingsystem.product.Product;
import de.neuefische.orderingsystem.product.ProductDb;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderDbTest {

    @Test
    public void testListOrders(){
        //Given
        OrderDb testOrderDb = getOrderDb();
        ArrayList<Order> expectedOrderList = new ArrayList<Order>(List.of(
                new Order("100", new Product[]{getProductDb().getProduct("100").get(), getProductDb().getProduct("101").get()}),
                new Order("101", new Product[]{getProductDb().getProduct("102").get(), getProductDb().getProduct("103").get()}),
                new Order("102", new Product[]{getProductDb().getProduct("104").get()})
        ));

        // When
        ArrayList<Order> actualOrderList = testOrderDb.listOrders();

        // Then
        assertTrue(expectedOrderList.size() == actualOrderList.size());
        assertTrue(expectedOrderList.containsAll(actualOrderList));
        assertTrue(actualOrderList.containsAll(expectedOrderList));
    }

    @Test
    public void testGetOrder(){
        // Given
        OrderDb testOrderDb = getOrderDb();
        String testOrderId = "1000";
        Order expectedOrder = new Order("100", new Product[]{getProductDb().getProduct("100").get(), getProductDb().getProduct("101").get()});

        // When
        Order testOrder = testOrderDb.getOrder(testOrderId).get();

        //Then
        assertEquals(expectedOrder, testOrder);

    }

    @Test
    public void testGetOrderWithNonExistingOrder(){
        // Given
        OrderDb testOrderDb = getOrderDb();
        String testOrderId = "2000";

        // When
        Optional<Order> testOrder = testOrderDb.getOrder(testOrderId);

        // Then
        assertTrue(testOrder.isEmpty());
    }

    @Test
    public void testAddOrder() {
        // Given
        OrderDb testOrderDb = getOrderDb();
        Order newOrder = new Order("108", new Product[]{getProductDb().getProduct("102").get()});

        // When
        testOrderDb.addOrder(newOrder);

        // Then
        assertTrue(testOrderDb.listOrders().contains(newOrder));

    }

    private static OrderDb getOrderDb(){

        HashMap<String, Order> testOrderHashMap = new HashMap<String, Order>(){{
            put("1000", new Order("100", new Product[]{getProductDb().getProduct("100").get(), getProductDb().getProduct("101").get()}));
            put("1001", new Order("101", new Product[]{getProductDb().getProduct("102").get(), getProductDb().getProduct("103").get()}));
            put("1002", new Order("102", new Product[]{getProductDb().getProduct("104").get()}));
        }};

        return new OrderDb(testOrderHashMap);

    }

    private static ProductDb getProductDb() {
        ArrayList<Product> testProducts = new ArrayList<Product>(List.of(
                new Clothing("100", "Dress"),
                new Clothing("101", "Jeans"),
                new Clothing("102", "Tshirt"),
                new Clothing("103", "Hoodie"),
                new Clothing("104", "Socks")
        ));

        return new ProductDb(testProducts);
    }

}