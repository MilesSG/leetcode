package com.company.leetcode.剑指offer;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/12/6
 */
public class Test16 {
    public static void main(String[] args) {
        int x = 3;
        int n = 4;
        System.out.println(new Test16().myPow(x, n));
    }

    public double myPow(double x, int n) {
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = (double)(res * x);
        }
        return res;
    }
}
