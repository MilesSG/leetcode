package com.company.leetcode;

/**
 * title: 28. 找出字符串中第一个匹配项的下标
 * 本题应该用经典的KMP算法，但我参考的是宫水三叶的朴素的解法
 *
 * @author: Miles
 * @date: 2022/10/11
 */
public class Test28 {
    public static void main(String[] args) {
        String haystack = "leetcode", needle = "co";
        System.out.println(new Test28().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        char[] charA = haystack.toCharArray();
        char[] charB = needle.toCharArray();
        // 枚举原串的起始点
        for (int i = 0; i <= m - n; i++) {
            int a = i;
            int b = 0;
            while (b < n && charA[a] == charB[b]) {
                a++;
                b++;
            }
            if (b == n) {
                return i;
            }
        }
        return -1;
    }
}
