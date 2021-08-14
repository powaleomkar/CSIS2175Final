package com.company;

public class Regular extends Savings {
    double TotalAmount;

    //calling super class saving constructor
    public Regular(String customerNumber, String customerName, Double initialDeposit, int numberOfYear, String savingType) {
        super(customerNumber, customerName, initialDeposit, numberOfYear, savingType);
    }

    //method count compound inters at interest rate of 10%
    public double generateTable() {
        this.TotalAmount = (this.InitialDeposit * (1 + 0.10 / 12) * (12 * this.NumberOfYear) - this.InitialDeposit);
        return this.TotalAmount;
    }
}
