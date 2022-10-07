package com.company.leetcode;

/**
 * title: 14. 最长公共前缀
 *
 * @author: Miles
 * @date: 2022/10/7
 */
public class Test14 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = compare(prefix, strs[i]);
        }
        return prefix;
    }

    private static String compare(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len;) {
            if (str1.charAt(i) == str2.charAt(i)) {
                i++;
            } else {
                return str1.substring(0, i);
            }
        }
        return str2.substring(0, len);
    }
}
