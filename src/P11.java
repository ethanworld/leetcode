package src;

import util.UnitTest;

/**
 * P11
 * 题目：11. 盛最多水的容器
 * 算法：双指针，贪心
 */
public class P11 {

    public int maxArea(int[] height) {
    
        // 先固定最大宽度，再通过双指针选局部最优
        int left =0, right = height.length - 1, max = 0;
        while (left < right) {
            max = Integer.max(max, Integer.min(height[left], height[right]) * (right - left));
            // 每次都移动较矮的一端：如此移动后的容器才有机会比当前更大
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                // 当两端高度相同时，以任意一端作为边界缩短另一端，容量都在减少
                // 索性两端都移动：如此移动后的容器才有机会比当前更大
                left++;
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P11 p11 = new P11();
        int rst;
        int[] arr;
        
        arr = new int[]{1,8,6,2,5,4,8,3,7};
        rst = p11.maxArea(arr);
        UnitTest.EXPERT_EQ(rst, 49);
    }
}
