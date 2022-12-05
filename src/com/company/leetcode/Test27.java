package com.company.leetcode;

/**
 * title: 27. 移除元素
 *
 * @author: Miles
 * @date: 2022/10/10
 */
public class Test27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(new Test27().removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}