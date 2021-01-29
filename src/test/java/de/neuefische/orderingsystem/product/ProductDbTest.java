package de.neuefische.orderingsystem.product;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ProductDbTest {

    @Test
    public void testGetProductList(){
        //Given
        ProductDb testDb = getProductDb();
        ArrayList<Product> expectedProductList = new ArrayList<Product>(List.of(
                new Product("100", "Dress"),
                new Product("101", "Jeans"),
                new Product("102", "Tshirt"),
                new Product("103", "Hoodie"),
                new Product("104", "Socks")
        ));

        // When
        ArrayList<Product> actualProductList = testDb.listProducts();

        // Then
        assertEquals(expectedProductList, actualProductList);

    }

    @Test
    public void testGetProduct(){
        //Given
        ProductDb testDb = getProductDb();
        String productId = "103";
        Product expectedProduct = new Product("103", "Hoodie");

        // When
        Product actualProduct = testDb.getProduct(productId);

        // Then
        assertEquals(expectedProduct, actualProduct);

    }

    @Test
    public void testGetProductWithNonExistingId(){
        //Given
        ProductDb testDb = getProductDb();
        String productId = "203";

        // When
        try {
            testDb.getProduct(productId);
            fail();
        } catch(Exception exception){
            // Then
            assertEquals("Product not found in database", exception.getMessage());
        }

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