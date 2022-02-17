package com.company;

import com.company.data.AppData;
import com.company.menu.MenuStart;
import com.company.saving.Saving;

import java.awt.*;
import java.util.ArrayList;

import static com.company.menu.MenuStart.startMenuWhoIsNotLogged;

public class Main {
    public final static String fileUser = "src/com/company/data/Users.txt";
    public final static String fileCategory = "src/com/company/data/Category.txt";

    public static void main(String[] args) {

//        Menu menu = new Menu(Saving.initializeFromFileUsers(fileUser));
//        AppData.initializeUser();
//        Saving.saveToFileUsers(fileUser);
//
//        AppData.existingProduct();
//        Saving.saveToFileCategories(fileCategory);
//
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
