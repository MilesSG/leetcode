package com.company.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/10/8
 */
public class Test22 {
    public static void main(String[] args) {
        System.out.println(new Test22().generateParenthesis(3));
    }

    List<String> res = new LinkedList<>();
    int pair = 0;

    public List<String> generateParenthesis(int n) {
        pair = n;
        dfs("", 0, 0);
        return res;
    }

    private void dfs(String path, int left, int right) {
        if (path.length() == 2 * pair) {
            res.add(path.toString());
        }
        if (left < pair) {
            dfs(path + "(", left + 1, right);
        }
        if (right < left) {
            dfs(path + ")", left, right + 1);
        }
    }
}
