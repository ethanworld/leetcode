package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/9 10:33
 * @Version: 1.0
 * @Desc :
 */
public class P209 {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, sum = 0;
        int res  = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];

            // left向右缩短
            while (sum >= target && left >= 0 && left <= right) {
                if (sum - nums[left] < target) {
                    break;
                }
                sum -= nums[left];
                left++;
            }
            // left向左变长
            while (sum < target && left > 1) {
                left--;
                sum += nums[left];
            }

            // 更新长度
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
            }

            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        P209 p209 = new P209();
        System.out.println(p209.minSubArrayLen(7, new int[] { 2,3,1,2,4,3 }));
    }
}
