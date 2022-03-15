package com.company.menu;

import com.company.Category;
import com.company.data.AppData;
import com.company.Product;
import com.company.User;
import com.company.helper.ScannerHelper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class MenuStart {
    private static final String START_MENU = "***WELCOME***"
            + "\n\t1 - Show product"
            + "\n\t2 - Authorization"
            + "\n\t0 - Exit";
    private static final String VIEWING_PRODUCTS = "\n\t1 - Go back to selecting categories"
            + "\n\t0 - Exit the program";

    public static final String INCORRECT = "THERE IS NO SUCH ACTION!!!";
    public static final String SELECT_ACTION = "\nSELECT AN ACTION:\n ";


    public static void startMenuWhoIsNotLogged(ArrayList <User> users, ArrayList<Category> categories) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(START_MENU + SELECT_ACTION)) {
                case 1:
                    viewProduct(categories);
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
        ScannerHelper.close();
    }


    private static void viewCategory(ArrayList<Category> categories) {
        System.out.println("Product categories:");
        System.out.format("+----+---------------------+%n");
        System.out.format("| №  |  Categories         |%n");
        System.out.format("+----+---------------------+%n");
        for (int i = 0; i < categories.size(); i++) {
            System.out.format("%-5s%-22s%1s", "| " + (i + 1) + ".", "| " + categories.get(i).getName(), "|\n");
        }
        System.out.format("+----+---------------------+");
        System.out.println("\n");
    }

    private static int selectCategory(ArrayList<Category> categories) {
        viewCategory(categories);
        System.out.println("Enter the category number to view the products:\n");
        int num = ScannerHelper.readInt() - 1;
        return num;
    }

    private static void viewProduct(ArrayList<Category> categories) {
        ArrayList<Product> products = categories.get(selectCategory(categories)).getProducts();
        System.out.println("List of products:");
        System.out.format("+----+---------------------+-------------+---------+%n");
        System.out.format("| №  |  Product            | Price       | Rating  |%n");
        System.out.format("+----+---------------------+-------------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-22s%-14s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| "
                    + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| "
                    + products.get(i).getRating(), "|\n");
        }
        System.out.format("+----+---------------------+-------------+---------+");
        choosingActionsAfterViewProduct(categories);
    }

    private static void choosingActionsAfterViewProduct (ArrayList<Category>categories){
        switch (ScannerHelper.getIntFromInput(VIEWING_PRODUCTS + SELECT_ACTION)) {
            case 1:
                viewProduct(categories);
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println(INCORRECT);
                break;
        }
    }
}
