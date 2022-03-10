package com.company.menu;

import com.company.data.AppData;
import com.company.Product;
import com.company.User;
import com.company.helper.ScannerHelper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MenuAuthorizedUser {
    private static final String MAIN_MENU = "Select the desired menu item:"
            + "\n\t1 - Show product"
            + "\n\t2 - Show the product in the shopping cart"
            + "\n\t3 - Show order history"
            + "\n\t0 - Exit";
    private static final String ACTIONS_PRODUCT = "\n\t1 - Add product to the shopping cart"
            + "\n\t0 - Go back";

    private static int NUM_SELECT_CATEGORY;
    private static int NUM_SELECT_PRODUCT;

    public static void startMenuWhoIsLogged(User user) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(MAIN_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
                    viewProduct(user);
                    break;
                case 2:
                    viewProductBasket(user);
                    break;
                case 3:
                    viewBuyingHistory(user);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println(MenuStart.INCORRECT);
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

    private static void viewProduct(User user) {
        selectCategory(NUM_SELECT_CATEGORY);
        System.out.println("List of products:");
        ArrayList<Product> products = AppData.categories.get(NUM_SELECT_CATEGORY).getProducts();
        System.out.format("+----+---------------------+-------------+---------+%n");
        System.out.format("| №  |  Product            | Price       | Rating  |%n");
        System.out.format("+----+---------------------+-------------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-22s%-14s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| " + products.get(i).getRating(), "|\n");
        }
        System.out.format("+----+---------------------+-------------+---------+");
        System.out.println("\n");
        selectProduct(products, user);
    }

    private static void selectProduct(ArrayList<Product> products, User user) {
        System.out.println("Select the product:\n");
        NUM_SELECT_PRODUCT = ScannerHelper.readInt() - 1;
        Product product = products.get(NUM_SELECT_PRODUCT);
        System.out.println("SELECTED PRODUCT: " + product.getName() + " " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getPrice()));
        switch (ScannerHelper.getIntFromInput(ACTIONS_PRODUCT + MenuStart.SELECT_ACTION)) {
            case 1:
                addProductInBasket(product, user);
                break;
            case 0:
                viewProduct(user);
                break;
        }
    }

    //TODO количество товара
    private static void addProductInBasket(Product product, User user) {
        user.addProductToBasket(product);
//        System.out.println("Specify the number of products");
//        int number = ScannerHelper.readInt();
        System.out.println("** Great! The product has been added to the cart. **\n");

    }

    private static void viewProductBasket(User user) {
        System.out.println("Products in your shopping cart:\n");
        user.showBasket();
        System.out.format("%-5s%-24s%-14s%-10s%-10s%1s", "|" , "|        TOTAL:" , "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(user.getBasket().total()), "| " , "| " , "|\n");
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
        ArrayList<Product> products = new ArrayList<>();
        MenuBasket.startActionsMenuInBasket(user, products);
    }

    private static void viewBuyingHistory(User user) {
        System.out.println("Your order history:\n");
        user.showBuying();
    }
}
