package com.company.saving;

import com.company.Product;
import com.company.data.AppData;
import com.company.Category;
import com.company.User;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeMap;

import static com.company.menu.MenuStart.startMenuWhoIsNotLogged;

public class Saving implements Serializable{
    public final static String fileUser = "src/com/company/data/Users.txt";
    public final static String fileCategory = "src/com/company/data/Category.txt";
    public final static String fileProductBuyingHistory = "src/com/company/data/BuyingHistory.txt";

    public static void startInit () {
        ArrayList<User> users = InitializeFromFile.initializeFromFile(fileUser);
        users = AppData.initializeUser();
        SaveToFile.saveToFile(users, fileUser);
        ArrayList<Category> categories = InitializeFromFile.initializeFromFile(fileCategory);
        categories = AppData.existingProduct();
        SaveToFile.saveToFile(categories, fileCategory);
//        TreeMap<Integer, ArrayList<Product>> buyHistory = InitializeFromFile.initializeFromFileBuyHistory(fileProductBuyingHistory);
//        SaveToFile.saveToFileBuyHistory(buyHistory, fileProductBuyingHistory);

        startMenuWhoIsNotLogged(users);
    }

}
