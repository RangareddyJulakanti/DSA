package com.ranga.java8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        System.out.println(threadPoolExecutor.getCorePoolSize());
        executorService.submit(()->{
            System.out.println("Task1");
        });

        executorService.submit(()->{
            System.out.println("Task2");
            //throw new RuntimeException("Exception");
        });

        Thread.sleep(5000);
        System.out.println(threadPoolExecutor.getCorePoolSize());

    }
}
