package com.company.easy;

/**
 * title: 495. 提莫攻击
 *
 * @author: Miles
 * @date: 2022/9/9
 */
public class Test495 {
    public static void main(String[] args) {
        int[] timeSeries = new int[]{1, 3, 4, 7, 13};
        int duration = 2;
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int right = timeSeries[0] + duration - 1;
        int res = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] > right) {
                right = timeSeries[i] + duration - 1;
                res += duration;
                continue;
            }
            res += timeSeries[i] - timeSeries[i - 1];
            right = timeSeries[i] + duration - 1;
        }
        res += duration;
        return res;
    }
}
