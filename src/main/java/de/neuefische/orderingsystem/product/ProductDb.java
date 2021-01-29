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

        if (!this.containsProduct(id)) {
            throw new IllegalArgumentException("Product not found in database");
        } else {
            for (Product product : this.productList) {
                if (product.getId().equals(id)) {
                    return product;
                }
            }
        }
        return null;
    }

    private boolean containsProduct(String id) {
        for (Product product : this.productList) {
            if (product.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ProductDb{" +
                "productList=" + productList +
                '}';
    }
}
