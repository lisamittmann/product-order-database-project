package de.neuefische.orderingsystem.product;

import java.util.ArrayList;
import java.util.Optional;

public class ProductDb {

    private ArrayList<Product> productList;

    public ProductDb(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> listProducts() {
        return this.productList;
    }

    public Optional<Product> getProduct(String id) {

        for (Product product : this.productList) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }



    @Override
    public String toString() {
        return "ProductDb{" +
                "productList=" + productList +
                '}';
    }
}
