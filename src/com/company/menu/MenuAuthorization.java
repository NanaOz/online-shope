package com.company.menu;

import com.company.Category;
import com.company.User;
import com.company.data.AppData;
import com.company.helper.ScannerHelper;

import java.util.ArrayList;
import java.util.Collections;

public class MenuAuthorization {
    private ArrayList<User> users;
    private static final String AUTHENTICATION_MENU = "\t1 - Log in"
            + "\n\t2 - Register"
            + "\n\t0 - Back";

    public static void startMenuAuthentication(ArrayList<User> users) {
        boolean itContinues = true;
        while (itContinues) {
            switch (ScannerHelper.getIntFromInput(AUTHENTICATION_MENU + MenuStart.SELECT_ACTION)) {
                case 1:
                    login(users);
                    break;
                case 2:
                    registration(users);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println(MenuStart.INCORRECT);
                    break;
            }
        }
    }

    private static User authentication() {
        User user = new User();
        System.out.print("Login:\n");
        user.setLogin(ScannerHelper.readString());
        System.out.print("Password:\n");
        user.setPassword(ScannerHelper.readString());
        return user;
    }

    private static User login(ArrayList<User> users) {
        User user = authentication();
        for (User u : users) {
            if (u.equals(user) == true) {
                MenuAuthorizedUsers.startMenuWhoIsLogged(user);
                return user;
            }
        }
        System.out.println("Login or password is incorrect!");
        authentication();
        return user;
    }

    private static void registration(ArrayList<User> users) {
        User user = new User();
        System.out.println("Enter your username:\n");
        user.setLogin(ScannerHelper.readString());
        System.out.println("Enter your password:\n");
        user.setPassword(ScannerHelper.readString());
        Collections.addAll(users, user);
        System.out.println("Congratulations! You are registered!");
        MenuAuthorizedUsers.startMenuWhoIsLogged(user);
    }
}
