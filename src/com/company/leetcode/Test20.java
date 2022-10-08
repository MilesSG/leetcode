package com.company.leetcode;

import java.util.Stack;

/**
 * title: 20. 有效的括号
 *
 * @author: Miles
 * @date: 2022/10/8
 */
public class Test20 {
    public static void main(String[] args) {
        String s = "()[]{}}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty()) {
                return false;
            } else if (c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
