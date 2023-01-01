package com.company.leetcode.剑指offer;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/12/5
 */
public class Test05 {
    public static void main(String[] args) {

    }

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
