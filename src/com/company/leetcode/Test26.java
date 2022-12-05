package com.company.leetcode;

import java.util.HashSet;

/**
 * title: 26. 删除有序数组中的重复项
 * 这题挺有技巧的，东哥题解 使用双指针 fast是一定移动的，只有slow和fast指针所对应的值
 * 不相等的时候才将slow右移，而且要注意的是，是先移动slow指针，然后再进行赋值操做
 *
 * @author: Miles
 * @date: 2022/10/10
 */
public class Test26 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new Test26().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
