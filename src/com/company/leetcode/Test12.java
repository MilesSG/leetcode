package com.company.leetcode;

/**
 * title: 12. 整数转罗马数字
 *
 * @author: Miles
 * @date: 2022/10/7
 */
public class Test12 {
    public static void main(String[] args) {
        int num = 213;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        // 个位：1 2 3 4 5 6 7 8 9 为了防止有-1这种下标越界的异常，在开头加上一个空字符
        String[] one = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        // 十位：10 20 30 40 50 60 70 80 90
        String[] two = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 百位：100 200 300 400 500 600 700 800 900
        String[] three = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 千位：1000 2000 3000
        String[] four = new String[]{"", "M", "MM", "MMM"};
        return four[num / 1000] + three[num % 1000 / 100] + two[num % 100 / 10] + one[num % 10]
                ;
    }
}
