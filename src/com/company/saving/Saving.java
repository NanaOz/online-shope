package com.company.saving;

import com.company.Product;
import com.company.data.AppData;
import com.company.Category;
import com.company.User;

import java.io.*;
import java.util.ArrayList;

import static com.company.menu.MenuStart.startMenuWhoIsNotLogged;

public class Saving implements Serializable{
    public final static String fileUser = "src/com/company/data/Users.txt";
    public final static String fileCategory = "src/com/company/data/Category.txt";
    public final static String fileProductBuyingHistory = "src/com/company/data/BuyingHistory.txt";

    public static void saveToFileUsers(ArrayList<User> users, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
            oos.writeObject(AppData.users);
            System.out.printf("The object is recorded\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<User> initializeFromFileUsers(String file) {
        ArrayList<User> users = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            users = (ArrayList<User>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void saveToFileCategories(ArrayList<Category> categories, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(categories);
            System.out.printf("The object is recorded\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Category>  initFromFileCategories(String file) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            categories = (ArrayList<Category>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    //для истории покупок
    public static void saveToFileBasketHistory(ArrayList<Product> buying, String file) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false));
            oos.writeObject(buying);
            System.out.printf("The object is recorded\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Product> initFromFileProductsBasketHistory(String file) {
        ArrayList<Product> buing = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            buing = (ArrayList<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buing;
    }

    public static void startInit () {
        ArrayList<User> users = initializeFromFileUsers(fileUser);
        users = AppData.initializeUser();
        saveToFileUsers(users, fileUser);
        ArrayList<Category> categories = initFromFileCategories(fileCategory);
        categories = AppData.existingProduct();
        saveToFileCategories(categories, fileCategory);
        ArrayList<Product>buying = initFromFileProductsBasketHistory(fileProductBuyingHistory);
        buying = AppData.products;
        saveToFileBasketHistory(buying, fileProductBuyingHistory);
        startMenuWhoIsNotLogged(users);
    }

}
