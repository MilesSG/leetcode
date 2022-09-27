package com.company.leetcode;

import java.util.Arrays;

/**
 * title: 4. 寻找两个正序数组的中位数
 *
 * @author: Miles
 * @date: 2022/9/27
 */
public class Test4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = merge(nums1, nums2);
        int len = nums.length;
        if (nums.length % 2 == 0) {
            return (nums[(len - 1) / 2] + nums[len / 2]) / 2.0;
        } else {
            return nums[len / 2] * 1.0;
        }
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums[i + nums1.length] = nums2[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
