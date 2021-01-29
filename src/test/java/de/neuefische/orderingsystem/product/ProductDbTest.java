package de.neuefische.orderingsystem.product;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductDbTest {

    @Test
    public void testGetProductList(){
        //Given
        ProductDb testDb = getProductDb();
        ArrayList<Product> expectedProductList = new ArrayList<Product>(List.of(
                new Clothing("100", "Dress"),
                new Clothing("101", "Jeans"),
                new Clothing("102", "Tshirt"),
                new Clothing("103", "Hoodie"),
                new Clothing("104", "Socks"),
                new Furniture("600", "Sofa")
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
        Clothing expectedClothing = new Clothing("103", "Hoodie");

        // When
        Optional<Product> actualProduct = testDb.getProduct(productId);

        // Then
        assertEquals(expectedClothing, actualProduct.get());

    }

    @Test
    public void testGetProductWithNonExistingId(){
        //Given
        ProductDb testDb = getProductDb();
        String productId = "203";

        // When
        Optional<Product> actualProduct = testDb.getProduct(productId);

        //Then
        assertTrue(actualProduct.isEmpty());

    }

    private static ProductDb getProductDb() {
        ArrayList<Product> testClothings = new ArrayList<Product>(List.of(
                new Clothing("100", "Dress"),
                new Clothing("101", "Jeans"),
                new Clothing("102", "Tshirt"),
                new Clothing("103", "Hoodie"),
                new Clothing("104", "Socks"),
                new Furniture("600", "Sofa")
        ));

        return new ProductDb(testClothings);
    }

}