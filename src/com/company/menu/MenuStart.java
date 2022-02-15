package com.company.menu;

import com.company.data.AppData;
import com.company.Product;
import com.company.User;
import com.company.helper.ScannerHelper;

import java.util.ArrayList;

public class MenuStart {
    private static final String START_MENU = "Welcome!"
            + "\n\t1 - Show product"
            + "\n\t2 - Authorization"
            + "\n\t0 - Exit";
    private static final String VIEWING_PRODUCTS = "\n\t1 - Go back to selecting categories"
            + "\n\t2 - Go back to the main menu"
            + "\n\t0 - Exit the program";

    public static final String INCORRECT = "There is no such action!";
    public static final String SELECT_ACTION = "\nSelect an action:\n ";

    private static int NUM_SELECT_CATEGORY;

    public MenuStart(ArrayList<User> initializeFromFile) {
    }

    public MenuStart() {
    }

    public static void startMenuWhoIsNotLogged(ArrayList<User> users) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(START_MENU + SELECT_ACTION)) {
                case 1:
                    viewProduct(users);
                    break;
                case 2:
                    MenuAuthorization.startMenuAuthentication(users);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println(INCORRECT);
                    break;
            }
        }
    }


    private static void viewCategory() {
        System.out.println("Product categories:");
        System.out.format("+----+---------------------+%n");
        System.out.format("| №  |  Categories         |%n");
        System.out.format("+----+---------------------+%n");
        for (int i = 0; i < AppData.categories.size(); i++) {
            System.out.format("%-5s%-22s%1s", "| " + (i + 1) + ".", "| " + AppData.categories.get(i).getName(), "|\n");
        }
        System.out.format("+----+---------------------+");
        System.out.println("\n");
    }

    private static void selectCategory(int num) {
        viewCategory();
        System.out.println("Enter the category number to view the products:\n");
        NUM_SELECT_CATEGORY = ScannerHelper.readInt() - 1;
    }

    private static void viewProduct(ArrayList <User> users) {
        selectCategory(NUM_SELECT_CATEGORY);
        System.out.println("List of products:");
        ArrayList<Product> products = AppData.categories.get(NUM_SELECT_CATEGORY).getProducts();
        System.out.format("+----+---------------------+---------+---------+%n");
        System.out.format("| №  |  Product            | Price   | Rating  |%n");
        System.out.format("+----+---------------------+---------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-22s%-10s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| " + products.get(i).getPrice(), "| " + products.get(i).getRating(), "|\n");
        }
        System.out.format("+----+---------------------+---------+---------+");
        System.out.println("\n");
        switch (ScannerHelper.getIntFromInput(VIEWING_PRODUCTS + SELECT_ACTION)) {
            case 1:
                viewProduct(users);
                break;
            case 2:
                startMenuWhoIsNotLogged(users);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println(INCORRECT);
                break;


        }
    }
}
