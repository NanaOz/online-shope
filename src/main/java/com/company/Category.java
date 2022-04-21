package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable {
    private String name;
    private ArrayList<Product> products;

    public Category(String name, ArrayList<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }


    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
