package com.company.menu;

import com.company.Category;
import com.company.data.AppData;
import com.company.Product;
import com.company.User;
import com.company.helper.ScannerHelper;
import com.company.saving.SaveToFile;
import com.company.saving.StartInit;

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

    public static void startMenuWhoIsLogged(User user, ArrayList<Category> categories) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(MAIN_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
                    viewProducts(user, categories);
                    break;
                case 2:
                    viewProductBasket(user);
                    break;
                case 3:
                    viewBuyingHistory(user);
                    break;
                case 0:
                    save();
                    System.exit(0);
                default:
                    System.out.println(MenuStart.INCORRECT);
                    break;
            }
        }
    }

    private static void save () {
        SaveToFile.saveToFile(AppData.users, StartInit.fileUser);
        SaveToFile.saveToFile(AppData.categories, StartInit.fileCategory);
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

    private static void viewProducts(User user, ArrayList<Category> categories) {
//        selectCategory();
        ArrayList<Product> products = categories.get(selectCategory(categories)).getProducts();
        System.out.println("List of products:");
        System.out.format("+----+---------------------+-------------+---------+%n");
        System.out.format("| №  |  Product            | Price       | Rating  |%n");
        System.out.format("+----+---------------------+-------------+---------+%n");
        for (int i = 0; i < products.size(); i++) {
            System.out.format("%-5s%-22s%-14s%-10s%1s", "| " + (i + 1) + ".", "| " + products.get(i).getName(), "| " +
                    NumberFormat.getCurrencyInstance(Locale.getDefault()).format(products.get(i).getPrice()), "| "
                    + products.get(i).getRating(), "|\n");
        }
        System.out.format("+----+---------------------+-------------+---------+");
        System.out.println("\n");
        selectProduct(user, products);
    }

    private static void selectProduct(User user, ArrayList<Product> products) {
        System.out.println("Select the product:\n");
        int num = ScannerHelper.readInt() - 1;
        Product product = products.get(num);
        System.out.println("SELECTED PRODUCT: " + product.getName() + " "
                + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getPrice()));
        switch (ScannerHelper.getIntFromInput(ACTIONS_PRODUCT + MenuStart.SELECT_ACTION)) {
            case 1:
                addProductInBasket(product, user);
                break;
            case 0:
//                viewProducts(user,);
                break;
        }
    }

    private static void addProductInBasket(Product product, User user) {
        System.out.println("Specify the number of products");
        int number = ScannerHelper.readInt();
        user.addProductToBasket(product, number);
        System.out.println("** Great! The product has been added to the cart. **\n");
    }

    private static void viewProductBasket(User user) {
        System.out.println("Products in your shopping cart:\n");
        user.showBasket();
        System.out.format("%-5s%58s%-14s%1s", "|" , "TOTAL:" , "| "
                + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(user.getBasket().total()) , "|\n");
        System.out.format("+----+-----------------------+-------------+---------+---------+-------------+%n");
        ArrayList<Product> products = new ArrayList<>();
        MenuBasket.startActionsMenuInBasket(user, products);
    }

    private static void viewBuyingHistory(User user) {
        System.out.println("Your order history:\n");
        user.showBuying();
    }
}
