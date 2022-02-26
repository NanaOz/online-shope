package com.company.menu;

import com.company.Product;
import com.company.User;
import com.company.helper.ScannerHelper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MenuBasket {
    private static final String BASKET_MENU = "\n\t1 - Buy products"
            + "\n\t2 - Clear the shopping cart"
            + "\n\t3 - Select a product to change"
            + "\n\t0 - Go back to the main menu";
    private static final String CHANGE_BASKET = "\nChoose what you want to do:"
            + "\n\t1 - Remove a product from the shopping cart"
            + "\n\t2 - Change the number of product"
            + "\n\t0 - Go back to the main menu";

    private static int NUM_SELECT_PRODUCT_IN_BASKET;

    public static void startActionsMenuInBasket(User user, ArrayList<Product>products) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(BASKET_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
                    buyProduct(user, products);
                    break;
                case 2:
                    clearBasket(user);
                    break;
                case 3:
                    selectProductInBasket(user);
                    break;
                case 0:
                    MenuAuthorizedUser.startMenuWhoIsLogged(user);
                    break;
                default:
                    System.out.println(MenuStart.INCORRECT);
                    break;
            }
        }
    }

    public static void startActionsMenuInBasketWithSelectedProduct(Product product, User user) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(CHANGE_BASKET + MenuStart.SELECT_ACTION)) {
                case 1:
                    deleteProductBasket(product, user);
                    break;
                case 2:
                    //TODO добавить изменение количества товара
                    break;
                case 0:
                    itContinues = false;
                    break;
                default:
                    System.out.println(MenuStart.INCORRECT);
                    break;
            }
        }
    }

    private static void selectProductInBasket(User user) {
        System.out.println("Select the product:\n");
        ArrayList<Product> products = user.getBasket().getProducts();
        NUM_SELECT_PRODUCT_IN_BASKET = ScannerHelper.readInt() - 1;
        Product product = products.get(NUM_SELECT_PRODUCT_IN_BASKET);
        System.out.println("Selected: " + product.getName() + " " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getPrice()));
        startActionsMenuInBasketWithSelectedProduct(product, user);
    }

    private static void viewProductBasket(User user) {
        System.out.println("Products in your shopping cart:\n");
        user.showBasket();
        System.out.format("%-5s%-24s%-14s%-10s%-10s%1s", "|" , "|        TOTAL:" , "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(user.getBasket().total()), "| " , "| " , "|\n");
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
    }

    private static void deleteProductBasket(Product product, User user) {
        user.deleteFromBasket(product);
        System.out.println("** Product has been removed from your shopping cart. **\n");
        viewProductBasket(user);
    }

    private static void buyProduct(User user, ArrayList<Product> products) {
        user.buyProduct(products);
        System.out.println("** Congratulations!Products purchased! **");
        MenuAuthorizedUser.startMenuWhoIsLogged(user);
    }

    private static void clearBasket(User user) {
        user.deleteAllFromBasket();
        System.out.println("Your shopping cart is empty.... :(");
    }
}
