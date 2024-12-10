package com.oops.inheritance;

public  abstract class BaseAccount {
    long balance;

    public BaseAccount(long balance) {
        this.balance = balance;
    }

    public long getBalance(){
        return balance;
    }
    public  abstract double calculateInterest();
}
