package com.company.leetcode;

import java.util.HashSet;

/**
 * title: 3. 无重复字符的最长子串
 *
 * @author: Miles
 * @date: 2022/9/27
 */
public class Test3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
            int curLen = right - left;
            maxLen  =Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
