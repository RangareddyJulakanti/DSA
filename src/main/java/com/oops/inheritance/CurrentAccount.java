package com.oops.inheritance;

public class CurrentAccount extends BaseAccount {
    public CurrentAccount(long balance) {
        super(balance);
    }

    public double calculateInterest(){
        // Interest = Daily balance * (Number of Days) * Interest / (Days in a Year)
        return balance * 12 /365;
    }
}
