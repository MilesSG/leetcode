package com.company.easy;

import java.util.HashMap;
import java.util.HashSet;

/**
 * title: 387. 字符串中的第一个唯一字符
 *
 * @author: Miles
 * @date: 2022/9/7
 */
public class Test5 {
    public static void main(String[] args) {
        String str = "dddccdbba";
        System.out.println(firstUniqChar(str));

    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for(Character c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
