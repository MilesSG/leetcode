package com.company.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/**
 * title: 290. 单词规律
 *
 * @author: Miles
 * @date: 2022/9/8
 */
public class Test8 {
    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog cat cat dog";
        System.out.println(wordPattern(pattern, s));
    }

    public static boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        HashSet<Character> set = new HashSet<>();
        for (Character c : chars) {
            set.add(c);
        }
        // 将chars字符数组和strs字符串数组一一对应
        HashMap<Character, String> map = new HashMap<>();
        Arrays.sort(chars);
//        for (int i = 0; i < set.size(); i++) {
//            map.put(, strs[i]);
//        }
        int index = 0;
        for (Character c : set) {
            map.put(c, strs[index]);
            index++;
        }
//        for (int i = set.size(); i < chars.length; i++) {
//            if (map.get(i) != strs[i]) {
//                return false;
//            }
//        }
        for (int i = set.size(); i < chars.length; i++) {
            if (strs[i] != map.get('a')) {
                return false;
            }
        }
        return true;
    }
}
