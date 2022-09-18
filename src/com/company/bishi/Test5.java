package com.company.bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * title: 中兴0916笔试第二题 王海峰 力扣第6题原题
 *
 * @author: Miles
 * @date: 2022/9/16
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int numRows = sc.nextInt();
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] res = new String[numRows];
        Arrays.fill(res, "");
        char[] chars = s.toCharArray();

        int period = 2 * numRows  - 2;

        for (int i = 0; i < chars.length; i++) {
            // 取模
            int mod = i % period;
            if (mod < numRows) {
                // 正序添加
                res[mod] += chars[i];
            } else {
                // 倒叙添加
                res[period - mod] += chars[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str);
        }
        return sb.toString();
    }
}
