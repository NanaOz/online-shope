package com.company;

import com.company.data.AppData;
import com.company.saving.Saving;

import java.util.ArrayList;

import static com.company.menu.MenuStart.startMenuWhoIsNotLogged;

public class Main {
    public final static String fileUser = "src/com/company/data/Users.txt";
    public final static String fileCategory = "src/com/company/data/Category.txt";
    public static void main(String[] args) {

//        AppData.existing();
//        MenuStart menu = new MenuStart();
//        User user = menu.login();
//        System.out.println("Welcome, " + user.getLogin() + "!");
//        MenuStart.start();
//        MenuStart.startMenuWhoIsNotLogged();
        ArrayList<Category> categories = Saving.initFromFileCategories(fileCategory);
        categories = AppData.existingProduct();
        Saving.saveToFileCategories(categories, fileCategory);

        ArrayList<User> users = Saving.initializeFromFileUsers(fileUser);
        users = AppData.initializeUser();
        Saving.saveToFileUsers(users, fileUser);
        startMenuWhoIsNotLogged(users);



    }
}
