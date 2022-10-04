package com.company.leetcode;

/**
 * title: 7. 整数反转
 *
 * @author: Miles
 * @date: 2022/9/30
 */
public class Test7 {
    public static void main(String[] args) {
        int x = 123;
        int y = -1230;
        System.out.println(reverse(x));
        System.out.println(reverse(y));
    }

    public static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + tmp;
            x /= 10;
        }
        return res;
    }
}
