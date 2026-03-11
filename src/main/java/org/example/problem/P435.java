package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 11:45
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class P435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int[] dp = new int[intervals.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {

            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (intervals[j][1] <= intervals[i][0]) {
                    max = Math.max(dp[j], max);
                    // j倒序遍历，方便剪枝
                    // 如果当前j的right能满足i的left，那么比j更前的位置不可能有更大的max
                    break;
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;
    }

    public static void main(String[] args) {
        P435 p435 = new P435();
        int[][] intervals = new int[][]{{1,2}, {2,3},{3,4}, {1,3}};
        System.out.println(p435.eraseOverlapIntervals(intervals));
    }

}
