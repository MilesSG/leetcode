package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * title:
 *
 * @author: Miles
 * @date: 2023/1/3
 */
public class Test412FizzBuzz {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(fizzBuzz(3));
    }

    public static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }

        }
        return list;


    }
}
