package com.company.leetcode;

/**
 * title: 8. 字符串转换整数 (atoi)
 * 题解： https://www.bilibili.com/video/BV1bz4y1Q7Gq/?spm_id_from=333.337.search-card.all.click&vd_source=35aeaee52b15e78b11967f5ef3ce655a
 * @author: Miles
 * @date: 2022/10/3
 */
public class Test8 {
    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "  -42";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
    }

    public static int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int index = 0;
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        } else if (!Character.isDigit(firstChar)) {
            // 若是遇到非阿拉伯数字，直接返回0
            return 0;
        }

        long num = 0;
        long res = num * sign;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
            res = num * sign;
            if (res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            index++;
        }

        return (int) (num * sign);
    }


}
