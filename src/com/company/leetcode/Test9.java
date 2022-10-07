package com.company.leetcode;

/**
 * title: 9. 回文数
 *
 * @author: Miles
 * @date: 2022/10/4
 */
public class Test9 {
    public static void main(String[] args) {
        int x = 123452354;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0;
        int right  = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
