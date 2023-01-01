package com.company.leetcode.剑指offer;

import java.util.Arrays;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/12/6
 */
public class Test17 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Test17().printNumbers(1)));
    }

    public int[] printNumbers(int n) {
        int[] res = new int[(int)(Math.pow(10, n) - 1)];
        for (int i = 0; i < Math.pow(10, n); i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
