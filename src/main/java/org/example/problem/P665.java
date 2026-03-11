package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 10:36
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.Arrays;
import java.util.Stack;

public class P665 {

    public boolean checkPossibility(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] >= nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = Math.max(max + 1, 1);
            ans = Math.max(ans, dp[i]);
        }
        return ans  + 1  >= nums.length;
    }
    public static void main(String[] args) {
        P665 p = new P665();
        System.out.println(p.checkPossibility(new int[]{5,7,1,8}));
    }
}
