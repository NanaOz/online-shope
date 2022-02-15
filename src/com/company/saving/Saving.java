package com.company.saving;

import com.company.data.AppData;
import com.company.Category;
import com.company.User;

import java.io.*;
import java.util.ArrayList;

public class Saving {
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

    public static ArrayList<Category> initFromFileCategories(String file) {
        ArrayList<Category> categories = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            categories = (ArrayList<Category>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

}
