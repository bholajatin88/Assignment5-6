package com.jatin;

import javax.swing.*;

enum SERVICES {
    PackageA(100), PackageB(150);

    private int val;

    SERVICES(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }
}

enum OPTIONS {
    StorageSmall(8), StorageLarge(20.11);

    private double val;

    OPTIONS(double val) {
        this.val = val;
    }

    public double getVal() {
        return this.val;
    }
}

enum ITEMS {
    Boxessmall(2.50), Boxeslarge(4.50);

    private double val;

    ITEMS(double val) {
        this.val = val;
    }

    public double getVal() {
        return this.val;
    }
}

public class Program {
    private String userName = "Will";
    private String password = "pass";
    private String firstName;
    private String lastName;
    private int serviceHours;
    private int optionDays;
    private int itemBoxes;
    private double serviceCost;
    private double optionCost;
    private double itemCost;
    private double totalCost;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public double getOptionCost() {
        return optionCost;
    }

    public void setOptionCost(double optionCost) {
        this.optionCost = optionCost;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(String selectedService) {
        this.selectedService = selectedService;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    private String selectedService;
    private String selectedOption;
    private String selectedItem;

    public int getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(int serviceHours) {
        this.serviceHours = serviceHours;
    }

    public int getOptionDays() {
        return optionDays;
    }

    public void setOptionDays(int optionDays) {
        this.optionDays = optionDays;
    }

    public int getItemBoxes() {
        return itemBoxes;
    }

    public void setItemBoxes(int itemBoxes) {
        this.itemBoxes = itemBoxes;
    }

    public Program() {
        //Instance variables. Initialized at object creation
        this.selectedService = "";
        this.selectedItem = "";
        this.selectedOption = "";
        this.itemBoxes = 0;
        this.serviceHours = 0;
        this.optionDays = 0;
        this.itemCost = 0;
        this.serviceCost = 0;
        this.optionCost = 0;
        this.totalCost = 0;
    }

    //Constructor Overloading
    public Program(String selectedService, String selectedItem, String selectedOption,
                   int itemBoxes, int serviceHours, int optionDays,
                   int itemCost, int serviceCost, int optionCost, int totalCost) {
        //Instance variables. Initialized at object creation
        this.selectedService = selectedService;
        this.selectedItem = selectedItem;
        this.selectedOption = selectedOption;
        this.itemBoxes = itemBoxes;
        this.serviceHours = serviceHours;
        this.optionDays = optionDays;
        this.itemCost = itemCost;
        this.serviceCost = serviceCost;
        this.optionCost = optionCost;
        this.totalCost = totalCost;
    }

    //Instance Method
    public boolean login() {
        int i = 0;
        //Validate UserName and Password three times.
        while(i<3) {
            String inputUserName = JOptionPane.showInputDialog("Enter Username:");
            String inputPassword = JOptionPane.showInputDialog("Enter password:");
            if (inputUserName != null && inputPassword != null &&
                    inputUserName.equals(this.userName) && inputPassword.equals(this.password))
                break;
            i++;
            if(i<3)
                JOptionPane.showMessageDialog(null, "Incorrect Credentials. Please try again.");
        }

        if(i==3) {
            //Tries exceeded message shown using JOptionPane
            JOptionPane.showMessageDialog(null, "You have exceeded your try’s, goodbye.");
            return false;
        }
        return true;
    }

    public void inputNames() {
        String inputFirstName = JOptionPane.showInputDialog("Enter First Name:");
        while(inputFirstName == null || inputFirstName.equals("")) {
            inputFirstName = JOptionPane.showInputDialog("Invalid Input. Enter valid First name:");
        }
        String inputLastName = JOptionPane.showInputDialog("Enter Last Name:");
        while(inputLastName == null || inputLastName.equals("")) {
            inputLastName = JOptionPane.showInputDialog("Invalid Input. Enter valid Last name:");
        }
        this.setFirstName(inputFirstName);
        this.setLastName(inputLastName);
    }

    public void selectService() {
        String serviceMessage = "Available Services\n" +
                "Package A - $100/hr\nPackage B – $150/hr\n" +
                "Enter either A or B to select Service";
        String inputService = JOptionPane.showInputDialog(serviceMessage);
        while(inputService == null || !(inputService.equals("A") || inputService.equals("B"))) {
            String message = "Invalid Input. " + serviceMessage;
            inputService = JOptionPane.showInputDialog(message);
        }
        String selectedService;
        if(inputService.equals("A")) {
            selectedService = SERVICES.PackageA.toString();
        }
        else {
            selectedService = SERVICES.PackageB.toString();
        }
        this.setSelectedService(selectedService);

        String hoursMessage = "Enter number of hours for which Service " + inputService +
                " is required";
        String inputHours = JOptionPane.showInputDialog(hoursMessage);
        while(checkInteger(inputHours)) {
            String message = "Invalid Input. " + hoursMessage;
            inputHours = JOptionPane.showInputDialog(message);
        }
        this.setServiceHours(Integer.parseInt(inputHours));
    }

    public void selectOption() {
        String optionMessage = "Available Options\n" +
                "Storage Small – $8/day\nStorage Large – $20.11/day\n" +
                "Enter either S or L to select Option";
        String inputOption = JOptionPane.showInputDialog(optionMessage);
        while(inputOption == null || !(inputOption.equals("S") || inputOption.equals("L"))) {
            String message = "Invalid Input. " + optionMessage;
            inputOption = JOptionPane.showInputDialog(message);
        }
        String selectedOption;
        if(inputOption.equals("S")) {
            selectedOption = OPTIONS.StorageSmall.toString();
        }
        else {
            selectedOption = OPTIONS.StorageLarge.toString();
        }
        this.setSelectedOption(selectedOption);

        String daysMessage = "Enter number of days for which Option " + inputOption +
                " is required";
        String inputDays = JOptionPane.showInputDialog(daysMessage);

        while(checkInteger(inputDays)) {
            String message = "Invalid Input. " + daysMessage;
            inputDays = JOptionPane.showInputDialog(message);
        }
        this.setOptionDays(Integer.parseInt(inputDays));
    }

    public void selectItem() {
        String itemMessage = "Available Items\n" +
                "Boxes small - $2.50/per box\nBoxes large - $4.50/ per box\n" +
                "Enter either S or L to select Option";
        String inputItem = JOptionPane.showInputDialog(itemMessage);
        while(inputItem == null || !(inputItem.equals("S") || inputItem.equals("L"))) {
            String message = "Invalid Input. " + itemMessage;
            inputItem = JOptionPane.showInputDialog(message);
        }
        String selectedItem;
        if(inputItem.equals("S")) {
            selectedItem = ITEMS.Boxessmall.toString();
        }
        else {
            selectedItem = ITEMS.Boxeslarge.toString();
        }
        this.setSelectedItem(selectedItem);

        String boxMessage = "Enter number of boxes required for box type " + inputItem;
        String inputNumOfBoxes = JOptionPane.showInputDialog(boxMessage);
        while(checkInteger(inputNumOfBoxes)) {
            String message = "Invalid Input. " + boxMessage;
            inputNumOfBoxes = JOptionPane.showInputDialog(message);
        }
        this.setItemBoxes(Integer.parseInt(inputNumOfBoxes));
    }

    public boolean checkInteger(String input) {
        boolean check = false;
        try
        {
            if(input == null || input.equals("") || Integer.parseInt(input) <= 0)
                check = true;
        }
        catch (NumberFormatException ex)
        {
            check = true;
        }
        return check;
    }

    //Method below for each calculation
    public void calcServicesCost()
    {
        this.setServiceCost(SERVICES.valueOf(this.getSelectedService()).getVal() * this.getServiceHours());
    }

    public void calcOptionsCost()
    {
        this.setOptionCost(OPTIONS.valueOf(this.getSelectedOption()).getVal() * this.getOptionDays());
    }

    public void calcItemsCost()
    {
        this.setItemCost(ITEMS.valueOf(this.getSelectedItem()).getVal() * this.getItemBoxes());
    }

    public void calcTotalCost()
    {
        this.setTotalCost(this.getServiceCost() + this.getOptionCost() + this.getItemCost());
    }

    //Get and Display the input full name
    public void displayName() {
        String name = this.getFullName();
        JOptionPane.showMessageDialog(null, "The entered name is " + name);
    }

    //Method Overloading
    public void displayName(boolean isFirst) {
        String name;
        if(isFirst) {
            name = this.getFirstName();
            JOptionPane.showMessageDialog(null, "The entered First name is " + name);
        }
        else {
            name = this.getLastName();
            JOptionPane.showMessageDialog(null, "The entered Last name is " + name);
        }
    }

    //Display all the calculated costs
    public void displayAllCosts() {
        String message = "The Services Cost is " + String.format("%.2f", this.getServiceCost()) + "\n" +
                "The Options Cost is " + String.format("%.2f", this.getOptionCost()) + "\n" +
                "The Items Cost is " + String.format("%.2f", this.getItemCost()) + "\n" +
                "The Total Cost is " + String.format("%.2f", this.getTotalCost()) + "\n";
        JOptionPane.showMessageDialog(null, message);
    }
}
