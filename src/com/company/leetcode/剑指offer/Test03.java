package com.company.leetcode.剑指offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/12/5
 */
public class Test03 {
    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 0, 2, 5, 3};

    }

    public int findRepeatNumber(int[] nums) {
        HashSet set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}
