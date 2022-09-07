package com.company.bishi.tuhu0907;

/**
 * title:
 *
 * @author: Miles
 * @date: 2022/9/7
 */
public class Test3 {
    public int minVehiclePaintingCost (int[][] costs) {
        // write code here
        int[][] dp = new int[costs.length][costs[0].length];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < dp[0].length; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] = costs[i][j] + min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            res = Math.min(res, dp[dp.length - 1][i]);
        }
        return res;
    }
}





