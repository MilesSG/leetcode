package com.company.leetcode;

/**
 * title:
 *
 * @author: Miles
 * @date: 2023/1/3
 */
public class Test389找不同 {
    public static void main(String[] args) {

    }

    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return c;
            }
        }
        return ' ';
    }
}
