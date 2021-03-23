package com.androidapp.interfaceprograms;

public class BankAccount implements Measurable{
    private double balance;
    private int accountNumber;
    private static int lastAssignedNumber=1000;

    public BankAccount(double balance) {
        this.balance = balance;
        lastAssignedNumber++;
        accountNumber=lastAssignedNumber;
    }

    public double getMeasure() {
        return balance;
    }
}
