package com.company.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * title: 17. 电话号码的字母组合
 *
 * @author: Miles
 * @date: 2022/10/7
 */
public class Test17 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    static LinkedList<String> res = new LinkedList<String>();
    static String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    static StringBuilder path = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, 0);
        return res;
    }

    private static void dfs(String digits, int start) {
        if (path.length() == digits.length()) {
            res.add(path.toString());
        }
        for (int i = start; i < digits.length(); i++) {
            int digit = digits.charAt(i) - '0';
            for (Character c : map[digit].toCharArray()) {
                path.append(c);
                dfs(digits, i + 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
}
