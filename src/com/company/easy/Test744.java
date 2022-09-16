package com.company.easy;

import java.util.HashMap;

/**
 * title: 744. 寻找比目标字母大的最小字母
 *
 * @author: Miles
 * @date: 2022/9/9
 */
public class Test744 {
    public static void main(String[] args) {
        char[] letters = {'a', 'b'};
        System.out.println(nextGreatestLetter(letters, 'a'));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        HashMap<Character, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + index), index);
            index++;
        }
        // tmpIndex是比target大一个的字符所对应的下标
        int tmpIndex = map.get(target) + 1;
        char tmpChar = 'a';
        for (Character c : map.keySet()) {
            if (map.get(c) == tmpIndex) {
                return c;
            }
            tmpIndex++;
        }
        return 'a';
    }
}
