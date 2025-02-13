package com.ranga.java8;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerExample {
    public static void main(String[] args) {
//        Consumer<String> namesConsumer= (String name)->{
//            System.out.println(name);
//        };
      //  Consumer<String> namesConsumer= (name)->System.out.print(name);
      //  Consumer<String> namesConsumer= name->System.out.print(name);
       // Consumer<String> namesConsumer= System.out::print;
     //   Consumer<String> namesConsumer= System.out::print;

       // Stream.of("ranga","rakesh","kiran","samara").forEach(System.out::print);
       // BiConsumer<Integer,String> keyValueConsumer=;
        Map<Integer,String> map= new java.util.HashMap<>(Map.of(1, "ranga", 2, "rakesh", 3, "samara", 4, "raghu"));
        map.put(5,"Mohan");
        map.forEach((Integer key,String value)->System.out.println(key+" : "+value));
    }
}
