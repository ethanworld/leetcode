package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/9 14:32
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.Arrays;

public class P300 {

    public int lengthOfLIS(int[] nums) {

        // dp数组记录当前位置的最长序列长度
        int[] dp = new int[nums.length];
        // 默认每个元素自身保障序列至少为1
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int right = 1; right < nums.length; right++) {
            int res = 0;
            for (int left = right - 1; left >= 0 ; left--) {
                if (nums[left] < nums[right]) {
                    // 正向遍历过程，后者基于前者的dp结果
                    res = Math.max(res, dp[left]);
                }
            }
            if (res != 0) {
                dp[right] = res + 1;
                ans = Math.max(ans, dp[right]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        P300 p300 = new P300();
        System.out.println(p300.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

}
