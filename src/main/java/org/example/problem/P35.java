package org.example.problem;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 9:39
 * @Version: 1.0
 * @Desc :
 */
public class P35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
