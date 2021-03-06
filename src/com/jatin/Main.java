package com.jatin;

public class Main {
    public static void main(String[] args) {
        //Create Class object
        Program pro = new Program();
        //Call login instance method
        boolean loggedIn = pro.login();
        //Flag to check Login
        if(!loggedIn)
            return;
        //Input first and last name
        pro.inputNames();
        //Show prompts to get user selection of service, option and item
        pro.selectService();
        pro.selectOption();
        pro.selectItem();
        //Calculate cost for each selection
        pro.calcServicesCost();
        pro.calcOptionsCost();
        pro.calcItemsCost();
        //Calculate total cost
        pro.calcTotalCost();
        //Display all the calculated costs
        pro.displayAllCosts();
        //Display entered names as full name.
        pro.displayName();
    }
}
