package de.neuefische.orderingsystem.product;

import java.util.Objects;

public class Clothing implements Product {

    private String id;
    private String name;

    public Clothing(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothing clothing = (Clothing) o;
        return Objects.equals(id, clothing.id) && Objects.equals(name, clothing.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
