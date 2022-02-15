package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Basket implements Serializable {
    private ArrayList<Product> products;

    //    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd, MMMM, yyyy HH:mm:ss");
    Date date = new Date();

//    public Basket(ArrayList<Product> products, Date date) {
//        this.products = products;
//        this.date = date;
//    }

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
        System.out.format("+----+-----------------------+---------+---------+%n");
        System.out.format("| №  | Products in your cart | Price   | Rating  |%n");
        System.out.format("+----+-----------------------+---------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-24s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| " + products.get(i).getPrice(), "| " + products.get(i).getRating(), "|\n");
        }
        System.out.format("+----+-----------------------+---------+---------+%n");
    }

    public void delete(Product product) {
        this.products.remove(product);
    }

    public void deleteAll() {
        this.products.removeAll(products);
    }


}
