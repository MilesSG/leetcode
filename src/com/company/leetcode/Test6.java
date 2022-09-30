package com.company.leetcode;

import java.util.Arrays;

/**
 * title: 6. Z 字形变换
 * 题解参考：https://leetcode.cn/problems/zigzag-conversion/solution/java-si-lu-qing-xi-dai-ma-jian-ji-by-ven-2zlc/
 *
 * @author: Miles
 * @date: 2022/9/30
 */
public class Test6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = new StringBuilder();
        }
        int index = 0;
        int row = 0;
        int len = s.length();
        ;
        while (index < len) {
            while (index < len && row < numRows) {
                char ch = s.charAt(index);
                index++;
                res[row].append(ch);
                row++;
            }
            if (index == len) {
                break;
            }
            row = numRows - 2;
            while (index < len && row >= 0) {
                char ch = s.charAt(index);
                index++;
                res[row].append(ch);
                row--;
            }
            row += 2;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(res[i]);
        }
        return ans.toString();
    }
}
