package com.company.saving;

import com.company.Category;
import com.company.User;
import com.company.data.AppData;

import java.util.ArrayList;

import static com.company.menu.MenuStart.startMenuWhoIsNotLogged;

public class StartInit {
    public final static String fileUser = "src/com/company/data/Users.txt";
    public final static String fileCategory = "src/com/company/data/Category.txt";

    public static void startInit() {

        ArrayList<User> users = InitializeFromFile.initializeFromFile(fileUser);
        users = AppData.initializeUser();
        ArrayList<Category> categories = InitializeFromFile.initializeFromFile(fileCategory);
        categories = AppData.existingProduct();

        startMenuWhoIsNotLogged(users, categories); //передача юзер+категория
    }

}
