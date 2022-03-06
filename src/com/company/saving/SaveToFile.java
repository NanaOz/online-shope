package com.company.saving;

import com.company.Category;
import com.company.User;
import com.company.data.AppData;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class SaveToFile implements Serializable {
    public static void saveToFileUsers(ArrayList<User> users, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
//            oos.writeObject(AppData.users);
            oos.writeObject(users);
            System.out.printf("The object is recorded\n");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
}
