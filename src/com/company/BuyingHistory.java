package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class BuyingHistory implements Serializable {
    private ArrayList<Product> buying;
    private Date date;

    public BuyingHistory(ArrayList<Product> buying, Date date) {
        this.buying = buying;
        this.date = date;
    }

    public BuyingHistory(ArrayList<Product> buying) {
        this.buying = buying;
    }

    public BuyingHistory() {
        this.buying = new ArrayList<>();
    }

    public void addBuyingToHistory (ArrayList<Product>products) {

        this.buying.addAll(products);
    }

    public void showBuyingHistory() {
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        System.out.format("| №  | Buying product        | Price       | Rating  | Date    |%n");
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        for (int i = 0; i < buying.size(); i++) {
            System.out.format("%-5s%-24s%-10s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + buying.get(i).getName(), "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(buying.get(i).getPrice()), "| " + buying.get(i).getRating(), "| " + date, "|\n");
        }
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
    }
}
