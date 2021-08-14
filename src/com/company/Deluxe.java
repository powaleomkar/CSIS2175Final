package com.company;

public class Deluxe extends Savings {
    double TotalAmount;

    //calling super class saving constructor
    public Deluxe(String customerNumber, String customerName, Double initialDeposit, int numberOfYear, String savingType) {
        super(customerNumber, customerName, initialDeposit, numberOfYear, savingType);
    }


    //method count compound inters at interest rate of 15%
    public double generateTable() {
        this.TotalAmount = (this.InitialDeposit * (1 + 0.15 / 12) * (12 * this.NumberOfYear) - this.InitialDeposit);
        return this.TotalAmount;
    }
}
