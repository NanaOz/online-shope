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

    public static void startInit () {
        ArrayList<User> users = InitializeFromFile.initializeFromFileUsers(fileUser);
        users = AppData.initializeUser();
        SaveToFile.saveToFileUsers(users, fileUser);
        ArrayList<Category> categories = InitializeFromFile.initFromFileCategories(fileCategory);
        categories = AppData.existingProduct();
        SaveToFile.saveToFileCategories(categories, fileCategory);

        startMenuWhoIsNotLogged(users);
    }

}
