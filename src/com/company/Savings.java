package com.company;

public class Savings {

    // Field corresponding to data-base field
    String CustomerNumber;
    String CustomerName;
    Double InitialDeposit;
    int NumberOfYear;
    String SavingType;

    //Constructor with all 5 values to set data for each object
    public Savings(String customerNumber, String customerName, Double initialDeposit, int numberOfYear, String savingType) {
        CustomerNumber = customerNumber;
        CustomerName = customerName;
        InitialDeposit = initialDeposit;
        NumberOfYear = numberOfYear;
        SavingType = savingType;
    }

    //getters methods
    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public Double getInitialDeposit() {
        return InitialDeposit;
    }

    public int getNumberOfYear() {
        return NumberOfYear;
    }

    public String getSavingType() {
        return SavingType;
    }

    //Setters methods
    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setInitialDeposit(Double initialDeposit) {
        InitialDeposit = initialDeposit;
    }

    public void setNumberOfYear(int numberOfYear) {
        NumberOfYear = numberOfYear;
    }

    public void setSavingType(String savingType) {
        SavingType = savingType;
    }
}
