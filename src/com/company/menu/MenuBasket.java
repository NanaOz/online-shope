package com.company.menu;

import com.company.Product;
import com.company.User;
import com.company.data.AppData;
import com.company.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuBasket {
    private static final String BASKET_MENU = "\n\t1 - Buy products"
            + "\n\t2 - Clear the shopping cart"
            + "\n\t3 - Select a product to change"
            + "\n\t0 - Back";
    private static final String CHANGE_BASKET = "\nChoose what you want to do:"
            + "\n\t1 - Change items in the shopping cart"
            + "\n\t2 - Go back to the main menu";


    public static void startActionsMenuInBasket(User user) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(BASKET_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
//                    buyProduct();
                    break;
                case 2:
                    clearBasket(user);
                    break;
                case 3:
//                    selectProductInBasket();
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

    public static void startActionsMenuInBasketWithSelectedProduct(int num) {
        boolean itContinues = true;
        while (itContinues) {
            System.out.println(CHANGE_BASKET);
            Scanner in = new Scanner(System.in);
            int action = in.nextInt();
            switch (action) {
                case 1:
//                    clearBasket();
//                    deleteProductBasket();
                    break;
                case 2:
//                    startMenuWhoIsLogged();
                    break;
                default:
                    System.out.println(MenuStart.INCORRECT);
                    break;
            }
        }
    }

    private static void selectProductForAddToBasket(ArrayList<Product> products) {
//        viewProductFromCategory();
        System.out.println("Select the product:\n");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Product product = products.get(num - 1);
//        addProductInBasket(product);
    }

//    private static void viewProductBasket() {
//        System.out.println("Products in your shopping cart:\n");
//        User user = AppData.getUsers().get(LOGGED_IN_USER);
//        user.showBasket();
//        ArrayList<Product> products = new ArrayList<>();
////        startMenuToBasket();
//        startActionsMenuInBasket();
//    }
//
//    //TODO не выбирает и не проваливается в меню с изменение конкретного продукта
//    private static void selectProductInBasket() {
//        viewProductBasket();
//        System.out.println("Select the product:\n");
//        Scanner in = new Scanner(System.in);
//        NUM_SELECT_PRODUCT = in.nextInt();
////        Product product = products.get(NUM_SELECT_PRODUCT - 1);
////        startActionMenu(product);
//        startActionsMenuInBasketWithSelectedProduct(NUM_SELECT_PRODUCT);
//    }

    //TODO допилить.
//    private static void deleteProductBasket(Product product) {
//        User user = AppData.getUsers().get(LOGGED_IN_USER);
//        user.deleteFromBasket(product);
////        viewProductBasket();
////        System.out.println("Select the product you want to delete:\n");
////        Scanner in = new Scanner(System.in);
////        int num = in.nextInt();
////        AppData.baskets.remove(num);
//        System.out.println("Product has been removed from your shopping cart.\n");
//        startMenuWhoIsLogged(user);
//    }
//

//    private static void buyProduct() {
//        User user = AppData.getUsers().get(LOGGED_IN_USER);
//        user.deleteAllFromBasket();
//
//        System.out.println("Congratulations!Products purchased!");
//        startMenuWhoIsLogged(user);
//    }
//
    private static void clearBasket(User user) {
        user.deleteAllFromBasket();
        System.out.println("Your shopping cart is empty....");
    }
}
