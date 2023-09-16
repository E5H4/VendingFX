package com.example.vendingfx;

public class Customer {

    private String name;
    private double cash;

    public Customer(String name, double cash) {
        this.name = name;
        this.cash = cash;
    }

    public String buyDrink(Drink drink) { // drink is just a name to use to access past objects
        String result;
        if(cash >= drink.getPrice())
        {
            cash = cash - drink.getPrice();
            result = "Enjoy your " + drink.getName();
        }
        else {
            result = "Not enough $$$$";
        }
        return result;
    }

    public void setName(String cName) {
    }

    public void setCash(double cCash) {
    }
}
