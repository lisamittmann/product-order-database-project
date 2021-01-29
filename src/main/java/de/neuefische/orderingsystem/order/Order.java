package de.neuefische.orderingsystem.order;

import de.neuefische.orderingsystem.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class Order {

    private String id;
    private Product[] orderedProducts;


    public Order(String id, Product[] orderedProducts) {
        this.id = id;
        this.orderedProducts = orderedProducts;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Arrays.equals(orderedProducts, order.orderedProducts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(orderedProducts);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderedProducts=" + Arrays.toString(orderedProducts) +
                '}';
    }
}
