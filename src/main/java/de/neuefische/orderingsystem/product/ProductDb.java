package de.neuefische.orderingsystem.product;

import java.util.ArrayList;

public class ProductDb {

    private ArrayList<Product> productList;

    public ProductDb(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    public Product getProduct(String id) {

        for (Product product : this.productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new IllegalArgumentException("Product not found in database");

    }



    @Override
    public String toString() {
        return "ProductDb{" +
                "productList=" + productList +
                '}';
    }
}
