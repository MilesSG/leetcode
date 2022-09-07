package com.company.easy;

/**
 * title: 392. 判断子序列
 *
 * @author: Miles
 * @date: 2022/9/7
 */
public class Test6 {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        // left表示字符串s中的索引
        int left = 0;
        // right表示字符串t中的索引
        int right = 0;
        if (s.length() == 0 || t.length() == 0) return false;
        while (left < s.length()) {
            if (right == t.length()) {
                break;
            }
            if (s.charAt(left) == t.charAt(right)) {
                left++;
                right++;
            } else {
                right++;
                if (right == t.length()) {
                    break;
                }
            }
        }
        if (left == s.length()) {
            return true;
        }
        return false;
    }
}
