package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class User implements Serializable {
    private String login;
    private String password;
    private Basket basket;
    private BuyingHistory buyingHistory;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
        this.buyingHistory = new BuyingHistory();
    }

    public User() {
        this.basket = new Basket();
        this.buyingHistory = new BuyingHistory();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public void addProductToBasket(Product product) {
        this.basket.addBasket(product);
    }

    public void showBasket() {
        this.basket.show();
    }

    public void showBuying () {
        this.buyingHistory.showBuyingHistory();
    }

    public void deleteFromBasket(Product product) {
        this.basket.delete(product);
    }

    public void deleteAllFromBasket() {
        this.basket.deleteAll();
    }

    public void buyProduct(ArrayList<Product>products) {
        this.buyingHistory.addBuyingToHistory(products);
        deleteAllFromBasket();
    }


    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password=" + password +
                ", basket=" + basket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }
}
