package com.company.leetcode.剑指offer;

import java.util.Arrays;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/12/7
 */
public class Test21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(new Test21().exchange(nums)));
    }

    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] % 2 == 0 && nums[j] % 2 == 1) {
                swap(nums[i], nums[j]);
            } else if (nums[i] % 2 == 1){
                i++;
            } else if (nums[j] % 2 == 0) {
                j--;
            }
        }
        return nums;
    }

    private void swap(int num1, int num2) {
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
    }
}
