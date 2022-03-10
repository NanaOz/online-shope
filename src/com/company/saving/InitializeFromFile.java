package com.company.saving;

import com.company.BuyingHistory;
import com.company.Category;
import com.company.Product;
import com.company.User;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class InitializeFromFile implements Serializable {

    public static <T> ArrayList<T> initializeFromFile(String file) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

//    public static ArrayList<User> initializeFromFileUsers(String file) {
//        ArrayList<User> users = new ArrayList<>();
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            users = (ArrayList<User>) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//
//    public static ArrayList<Category>  initFromFileCategories(String file) {
//        ArrayList<Category> categories = new ArrayList<>();
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            categories = (ArrayList<Category>) ois.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return categories;
//    }
//
    public static TreeMap<Integer, ArrayList<Product>> initializeFromFileBuyHistory(String file) {
        TreeMap<Integer, ArrayList<Product>> buyHistory = new TreeMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            buyHistory = (TreeMap<Integer, ArrayList<Product>>) ois.readObject();
            int max=0;
            for(Integer key: buyHistory.keySet()){
                if(Integer.valueOf(key)>max) max = Integer.valueOf(key);
            }
            BuyingHistory.id=max;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buyHistory;
    }
}
