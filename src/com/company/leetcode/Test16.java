package com.company.leetcode;

import java.util.Arrays;

/**
 * title: 16. 最接近的三数之和
 *
 * @author: Miles
 * @date: 2022/10/7
 */
public class Test16 {
    public static void main(String[] args) {

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - tmp) < Math.abs(target - res)) {
                    res = tmp;
                }
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}
