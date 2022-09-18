package com.company.bishi;

import java.util.Scanner;

/**
 * title: 中兴0916笔试第二题 王海峰
 *
 * @author: Miles
 * @date: 2022/9/16
 */
public class Test6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        help(str);
    }

    private static void help(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] == 'T') {
                sb.append(i);
            }
        }
        int leng = sb.length();
        int sum = 0;
        if (leng % 2 == 1 || leng == 0) {
            System.out.println(0);
        } else if (leng == 2) {
            System.out.println(1);
        } else {
            for (int i = 0; i < leng - 1; i += 2) {
                sum += sb.toString().charAt(i + 1) - sb.toString().charAt(i);
            }
            System.out.println(sum);
        }
    }
}
