package com.company.data;

import com.company.Category;
import com.company.Product;
import com.company.User;

import java.util.ArrayList;
import java.util.Collections;

public class AppData {
    public static ArrayList<Category> categories = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();

    public static ArrayList<Category> existingProduct() {
        ArrayList<Product> outerwearProduct = new ArrayList<>();
        Product shirt = new Product("Shirt", 2000, 3);
        Product poloShirt = new Product("Polo Shirt", 3000, 4);
        Product tShirt = new Product("T-Shirt", 1000, 4);
        Collections.addAll(outerwearProduct, shirt, poloShirt, tShirt);
        Category outerwearCategory = new Category("Outerwear", outerwearProduct);

        ArrayList<Product> pantsProduct = new ArrayList<>();
        Product jeans = new Product("Jeans", 4000, 5);
        Product shorts = new Product("Shorts", 1500, 3);
        Product trousers = new Product("Trousers", 3000, 4);
        Collections.addAll(pantsProduct, jeans, shorts, trousers);
        Category pantsCategory = new Category("Pants", pantsProduct);

        ArrayList<Product> headdressProduct = new ArrayList<>();
        Product cap = new Product("Cap", 500, 5);
        Product scarf = new Product("Scarf", 1000, 4);
        Product hat = new Product("Hat", 1500, 4);
        Collections.addAll(headdressProduct, cap, scarf, hat);
        Category headdressCategory = new Category("Headdress", headdressProduct);

        Collections.addAll(categories, outerwearCategory, pantsCategory, headdressCategory);
        return categories;
    }

    public static ArrayList<User> initializeUser() {
        ArrayList<User> users = new ArrayList<>();
        User bob = new User("Bob", "1111");
        User paul = new User("Paul", "2222");
        User masha = new User("Masha", "3333");
        Collections.addAll(users, bob, paul, masha);
        return users;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static ArrayList<Category> getCategories() {
        return categories;
    }
}
