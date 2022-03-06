package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeMap;

public class BuyingHistory implements Serializable {
    private TreeMap<LocalDate, ArrayList<Product>> buyHistory;

    public BuyingHistory() {
        this.buyHistory = new TreeMap<>();
    }

    public void addBuyingToHistory(ArrayList<Product> products) {
        this.buyHistory.put(LocalDate.now(), products);
    }

    //TODO не выводит список покупок
    public void showBuyingHistory() {
        if (this.buyHistory.size() != 0) {
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("| №  | Buying product        | Price       | Rating  | Date    |%n");
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            for (LocalDate date : buyHistory.keySet()) {
                ArrayList<Product> products =buyHistory.get(date);
                for (int i = 0; i < products.size(); i++){
            System.out.format("%-5s%-24s%-10s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| " + products.get(i).getRating(), "| " + "date", "|\n");
                }
            }
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        } else {
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("| №  | Buying product        | Price       | Rating  | Date    |%n");
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("|               Oops.....You didn't buy anything               |%n");
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        }
    }
}
