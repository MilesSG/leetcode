package com.company.easy;

import java.util.*;

/**
 * title: 448. 找到所有数组中消失的数字
 *
 * @author: Miles
 * @date: 2022/9/9
 */
public class Test10 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
