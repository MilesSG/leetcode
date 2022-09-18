package com.company.middium;

import java.util.*;

/**
 * title: 139. 单词拆分
 *
 * @author: Miles
 * @date: 2022/9/16
 */
public class Test139 {
    public static void main(String[] args) {
        LinkedList<String> wordDict = new LinkedList<>();
        wordDict.add("code");
        wordDict.add("leet");
        String s = "leetcode";
        System.out.println(wordBreak(s, wordDict));
    }

    static int[] memo;

    public static boolean wordBreak(String s, List<String> wordDict) {

        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0, wordDict);
    }

    private static boolean dp(String s, int i, List<String> wordDict) {
        if (i == s.length()) return true;
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            if (dp(s, i + len, wordDict)) {
                memo[i] = 1;
                return true;
            }
        }
        memo[i] = 0;
        return false;
    }
}
