package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

public class Basket implements Serializable {
    private HashMap<Product, Integer> products;

    public Basket() {
        this.products = new HashMap<>();
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void addBasket(Product product, Integer quantity) {
        this.products.put(product, quantity);
    }

    public void show() {
        int i = 1;
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+%n");
        System.out.format("| №  | Products in your cart | Price       | Rating  |Number   |Total        |%n");
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+%n");
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            System.out.format("%-5s%-24s%-14s%-10s%-10s%-14s%1s", "| " + (i) + ".", "| " + product.getKey().getName(), "| "
                    + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getKey().getPrice()), "| "
                    + product.getKey().getRating(), "| " + product.getValue(), "| "
                    + NumberFormat.getCurrencyInstance(Locale.getDefault()).format((product.getKey().getPrice())*(product.getValue())), "|\n");
            i++;
        }
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+%n");
    }

    public void delete(Product product) {
        this.products.remove(product);
    }

    public void deleteAll() {
        this.products.clear();
    }

    public double total() {
        double sum = 0;
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            sum += (product.getKey().getPrice())*(product.getValue());
        }
        return sum;
    }


}
