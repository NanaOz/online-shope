package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class BuyingHistory implements Serializable {
    private TreeMap<Integer, ArrayList<Product>> buyHistory;
    public static int id=1;

    public BuyingHistory() {
        this.buyHistory = new TreeMap<>();
    }

    public void addBuyingToHistory(ArrayList<Product> products) {
        this.buyHistory.put(id++, products);
    }

    public static Integer getKeyByProduct (TreeMap<Integer, ArrayList<Product>> buyHistory, Product product){
        if (buyHistory.containsValue(product)) {
            for (Map.Entry <Integer, ArrayList<Product>>f: buyHistory.entrySet()){
                if (f.getValue().equals(product)){
                    return f.getKey();
                }
            }
        }
        return null;
    }

    //TODO не выводит список покупок
    public void showBuyingHistory() {
        if (!this.buyHistory.isEmpty()) {
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("| №  | Buying product        | Price       | Rating  | Date    |%n");
            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
//            for (Integer integer : buyHistory.keySet()) {
//                ArrayList<Product> products =buyHistory.get(integer);
            for (Map.Entry <Integer, ArrayList<Product>>p: buyHistory.entrySet()) {
                ArrayList<Product> products = buyHistory.get(p);
                for (int i = 0; i < products.size(); i++) {
                    System.out.format("%-5s%-24s%-10s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| "
                            + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| "
                            + products.get(i).getRating(), "| " + "date", "|\n");
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
