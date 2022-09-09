package com.company.easy;

/**
 * title: 520. 检测大写字母
 *
 * @author: Miles
 * @date: 2022/9/9
 */
public class Test520 {
    public static void main(String[] args) {


    }

    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.toLowerCase().equals(word)) {
            return true;
        }
        int n = word.length();
        int index = 1;
        if (Character.isUpperCase(word.charAt(0))) {
            while (index < n && Character.isLowerCase(word.charAt(index))) index++;
        }
        return index == n;
    }
}
