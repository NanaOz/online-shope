package com.company.menu;

import com.company.Product;
import com.company.User;
import com.company.data.AppData;
import com.company.helper.ScannerHelper;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class MenuBasket {
    public static int NUM_SELECT_PRODUCT_IN_BASKET;
    private static final String BASKET_MENU = "\n\t1 - Buy products || Купить товары"
            + "\n\t2 - Clear the shopping cart || Очистить корзину"
            + "\n\t3 - Select a product to change || Выбрать товар для изменения"
            + "\n\t0 - Go back to the main menu || Вернуться в главное меню";
    private static final String CHANGE_BASKET = "\nChoose what you want to do: || Выберите, что вы хотите сделать:"
            + "\n\t1 - Remove a product from the shopping cart || Удалить товар из корзины"
            + "\n\t2 - Change the number of product || Измените количество товара"
            + "\n\t0 - Go back to the main menu || Вернуться в главное меню";

//    private static Integer NUM_SELECT_PRODUCT_IN_BASKET;


    public static void startActionsMenuInBasket(User user) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(BASKET_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
                    buyProduct();
                    break;
                case 2:
                    clearBasket(user);
                    break;
                case 3:
                    selectProductInBasket(user);
                    break;
                case 0:
                    MenuAuthorizedUser.startMenuWhoIsLogged(user, AppData.categories);
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
        System.out.println("Select the product: || Выберите товар:\n");
//        ArrayList<Product> products = user.getBasket().getProducts();
        HashMap<Product, Integer> products = user.getBasket().getProducts();
        NUM_SELECT_PRODUCT_IN_BASKET = ScannerHelper.readInt() - 1;
//        Product product = products.get(p, NUM_SELECT_PRODUCT_IN_BASKET);
////        Product product = products.get(NUM_SELECT_PRODUCT_IN_BASKET);
//        System.out.println("Selected: " + product.getName() + " " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(product.getPrice()));
//        startActionsMenuInBasketWithSelectedProduct(product, user);
    }

    private static void viewProductBasket(User user) {
        System.out.println("Products in your shopping cart: || Товары в вашей корзине:\n");
        user.showBasket();
        System.out.format("%-5s%-24s%-14s%-10s%-10s%1s", "|" , "|        TOTAL:" , "| " + NumberFormat.getCurrencyInstance(Locale.getDefault()).format(user.getBasket().total()), "| " , "| " , "|\n");
        System.out.format("+----+-----------------------+-------------+---------+---------+%n");
    }

    private static void deleteProductBasket(Product product, User user) {
        user.deleteFromBasket(product);
        System.out.println("** Product has been removed from your shopping cart. || Товар был удален из вашей корзины. **\n");
        viewProductBasket(user);
    }

//    private static void buyProduct(User user, ArrayList<Product> products) {
//        user.buyProduct(products);
//        System.out.println("** Congratulations!Products purchased! **");
//        MenuAuthorizedUser.startMenuWhoIsLogged(user);
//    }

    private static void buyProduct(Product product, User user) {
        user.buyProduct(product, NUM_SELECT_PRODUCT_IN_BASKET);
        System.out.println("** Congratulations!Products purchased! || Поздравляю!Товары успешно куплены!**");
        MenuAuthorizedUser.startMenuWhoIsLogged(user, AppData.categories);
    }

    private static void clearBasket(User user) {
        user.deleteAllFromBasket();
        // map.entrySet().removeIf(entry -> entry.getKey() != 1); удаление ключ+знач
        System.out.println("Oops...Your shopping cart is empty.... :(");
        MenuAuthorizedUser.startMenuWhoIsLogged(user, AppData.categories);
    }
}
