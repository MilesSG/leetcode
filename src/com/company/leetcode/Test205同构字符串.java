package com.company.leetcode;

import java.util.HashMap;

/**
 * title:
 *
 * @author: Miles
 * @date: 2023/1/1
 */
public class Test205同构字符串 {
    public static void main(String[] args) {
        String s = "badc", t = "baba";
        System.out.println(isIsomorphic(s, t) && isIsomorphic(t, s));
    }

    public static boolean isIsomorphic(String s, String t) {
        return help(s, t) && help(t, s);
    }

    private static boolean help (String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        // 将两个字符串s和t建立对应关系
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), t.charAt(i));
        }
        // 再次遍历第一个字符串s，如果发现map所get()出来的字符与字符串t所指的字符与不一致时，就返回false
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
