package com.company.leetcode;

/**
 * title: 5. 最长回文子串
 *
 * @author: Miles
 * @date: 2022/9/27
 */
public class Test5 {
    public static void main(String[] args) {
        char[] chars = {'b', 'a', 'b', 'a', 'd'};
        System.out.println(longestPalindrome(String.valueOf(chars)));
    }

    public static String longestPalindrome(String s) {
        String res = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String tmp = s.substring(i, j);
                if (isHuiWen(tmp.toCharArray()) && tmp.length() > max) {
                    res = s.substring(i, j);
                    max = Math.max(max, res.length());
                }
            }
        }
        return res;
    }

    // 判断一个字符数组是否是回文子串
    private static boolean isHuiWen(char[] chars) {
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
