package com.oops.inheritance;

public class Client {
    public static void main(String[] args) {

        BaseAccount s=new SalaryAccount(1000);
        s=new SalaryAccount(1000);
        System.out.println(s.getClass().getName());
        System.out.println(s.getBalance());

        BaseAccount b=new CurrentAccount(1200);
        System.out.println(b.getClass().getName());
        System.out.println(b.getBalance());

        CurrentAccount c=new CurrentAccount(1200);
        c.calculateInterest();

         SalaryAccount s1=new SalaryAccount(1000);
         s1.getBalance();

        BaseAccount z = getAccount();
        //You cannot create object for abstract class directly you can create with its child class or derived class or implemented class.
        System.out.println(z.calculateInterest());

        //Method invocation is depending  on runtime object holding by parent reference.
        //This is called Method Overriding or Runtime/Dynamic Polymorphism

       // In Method overloading method invocation is done by parent reference this is called early loading or Static Polymorphism.
        /***
         *
         * 1.Parent class reference can hold any type of its derived class object
         * Here  BaseAccount  reference can hold either SalaryAccount object or CurrentAccount object
         *
         * by using that reference we can invoke only parent class methods but not child class methods.
         *
         *
         *
         *
         *
         *
          *  2.By using child class reference you can invoke either child class methods as well as parent class methods
         *   CurrentAccount currentAccount2=new CurrentAccount(1200);
         *    currentAccount2.getBalance();// parent class method which is there in Base Account
         *    currentAccount2.calculateInterest();// child class method which is in same class called CurrentAccount
         *
         *
         */
        Object o = new SalaryAccount(1000);
        System.out.println(o.toString());

    }
    public static BaseAccount getAccount(){
        return new SalaryAccount(1200);
    }



}
