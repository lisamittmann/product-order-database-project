package de.neuefische.orderingsystem.product;

import java.util.Objects;

public class Furniture implements Product {

    private String id;
    private String name;

    public Furniture(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return Objects.equals(id, furniture.id) && Objects.equals(name, furniture.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
