package com.ranga.multithreading;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionTest {

    public static void main(String args[]) throws InterruptedException {
          RaceCondition.runTest();
    }
}

class RaceCondition {

    AtomicInteger randInt=new AtomicInteger();
    Random random = new Random(System.currentTimeMillis());

     void  printer() {

        int i = 1000000;
        while (i != 0) {
            if (randInt.getAcquire() % 5 == 0) {
                if (randInt.getAcquire() % 5 != 0)
                  System.out.println(randInt.getAcquire());
            }
            i--;
        }
    }

     void modifier() {

        int i = 1000000;
        while (i != 0) {
            randInt.set( random.nextInt(1000));
            i--;
        }
    }

    public static void runTest() throws InterruptedException {


        final RaceCondition rc = new RaceCondition();
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.printer();
            }
        });
        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                rc.modifier();
            }
        });

        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}