package com.oops.inheritance;

public class SalaryAccount extends BaseAccount{


    public SalaryAccount(long balance) {
        super(balance);
    }

    public double calculateInterest(){
       return balance*(0.05*1/12);
    }

    @Override
    public String toString() {
        return "SalaryAccount{ } balance ="+balance;
    }
}
