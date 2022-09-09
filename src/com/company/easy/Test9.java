package com.company.easy;

/**
 * title: 434. 字符串中的单词数
 *
 * @author: Miles
 * @date: 2022/9/8
 */
public class Test9 {
    public static void main(String[] args) {
        String str = ", , , ,        a, eaefa";


    }

    public int countSegments(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < n && s.charAt(i) != ' ') {
                i++;
            }
            ans++;
        }
        return ans;
    }


}
