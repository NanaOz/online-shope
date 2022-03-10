package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Basket implements Serializable {
    private ArrayList<Product> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addBasket(Product product) {
        this.products.add(product);
    }

    public void show() {
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        System.out.format("| №  | Products in your cart | Price       | Rating  |Number   |%n");
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-24s%-14s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| "
                    + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| "
                    + products.get(i).getRating(), "| " + "кол-во", "|\n");
        }
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
    }

    public void delete(Product product) {
        this.products.remove(product);
    }

    public void deleteAll() {
        this.products.removeAll(products);
    }

    public double total() {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }


}
