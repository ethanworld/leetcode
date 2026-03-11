package org.example.problem;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 10:56
 * @Version: 1.0
 * @Desc :
 */
public class P53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
