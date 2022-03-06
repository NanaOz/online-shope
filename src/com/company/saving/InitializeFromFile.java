package com.company.saving;

import com.company.Category;
import com.company.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class InitializeFromFile implements Serializable {
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
}
