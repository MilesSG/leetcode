package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * title: 1. 两数之和
 *
 * @author: Miles
 * @date: 2022/9/26
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }
}
