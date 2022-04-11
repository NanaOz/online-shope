package com.company;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;

public class BuyingHistory implements Serializable {
    private HashMap<Product, Integer> buyHistory;
    public static int id = 1;

    public BuyingHistory() {
        this.buyHistory = new HashMap<>();
    }

//    public void addBuyingToHistory(ArrayList<Product> products) {
//        this.buyHistory.put(id++, products);
//    }

    public void addBuyingToHistory(Product product, Integer quantity) {
        this.buyHistory.put(product, quantity);
    }

    public static Integer getKeyByProduct(TreeMap<Integer, ArrayList<Product>> buyHistory, Product product) {
        if (buyHistory.containsValue(product)) {
            for (Map.Entry<Integer, ArrayList<Product>> f : buyHistory.entrySet()) {
                if (f.getValue().equals(product)) {
                    return f.getKey();
                }
            }
        }
        return null;
    }

    //TODO не выводит список покупок
    public void showBuyingHistory() {
        int i = 1;
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+-------------+%n");
        System.out.format("| №  | Buying product        | Price       | Rating  |Number   |Total        |Date         |%n");
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+-------------+%n");
        if (!this.buyHistory.isEmpty()) {
            for (Map.Entry<Product, Integer> product : buyHistory.entrySet()) {
                System.out.format("%-5s%-24s%-14s%-10s%-10s%-14s%-14s%1s", "| " + (i) + ".", "| " + product.getKey().getName(), "| "
                        + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getKey().getPrice()), "| "
                        + product.getKey().getRating(), "| " + product.getValue(), "| "
                        + NumberFormat.getCurrencyInstance(Locale.getDefault()).format((product.getKey().getPrice()) * (product.getValue())), "дата", "|\n");
                i++;
            }
            System.out.format("+----+-----------------------+-------------+---------+---------+-------------+-------------+%n");
////            for (Integer key : buyHistory.keySet()) {
////                ArrayList<Product> products = buyHistory.get(key);
//            for (Map.Entry<Product, Integer> product : buyHistory.entrySet()) {
////                ArrayList<Product> products = buyHistory.get(p);
////                for (int i = 0; i < products.size(); i++) {
////                    System.out.format("%-5s%-24s%-10s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| "
////                            + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| "
////                            + products.get(i).getRating(), "| " + "date", "|\n");
////                }
////                for (Product product : products) {
//                    System.out.format("%-5s%-24s%-10s%-10s%-10s%1s", "| " + (p) + ".", "| " + p.getKey()., "| "
//                            + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getPrice()), "| "
//                            + product.getRating(), "| " + "date", "|\n");
////                }
//            }
//            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        } else {
//            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
//            System.out.format("| №  | Buying product        | Price       | Rating  | Date    |%n");
//            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("|               Oops.....You didn't buy anything               |%n");
//            System.out.format("+----+-----------------------+-------------+---------+---------+%n");
            System.out.format("+----+-----------------------+-------------+---------+---------+-------------+-------------+%n");

        }
    }


//    public static void showBasket(User user) {
//        Basket basket = user.getBasket();
//        HashMap<Product, Number> products = basket.getProductsInBasket();
//        System.out.println("Корзина\n");
//        int i = 1;
//        System.out.println("№ " + " Наименование товара " + "Стоимость" + "Количество");
//        for (Map.Entry<Product, Number> product : products.entrySet()) {
//            System.out.println(i + ". " + "       " + product.getKey().getName() + "       " + " " + product.getKey().getPrice() +
//                    "       " + " " + product.getValue() + "\n");
//            i++;
//        }
//        System.out.println();
//    }
}

