package com.ranga.leetcode.arrays;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
      String a=  Stream.of("A","B","C","D").peek(System.out::print).findAny().orElse("NA");
      System.out.println(Optional.of("A"));
    }
}
