package com.company.easy;

/**
 * title: 9. 回文数
 *
 * @author: Miles
 * @date: 2022/9/12
 */
public class Test11 {
    public static void main(String[] args) {
        int i = 1341414;

    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
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
