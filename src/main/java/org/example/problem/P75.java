package org.example.problem;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 11:00
 * @Version: 1.0
 * @Desc :
 */
public class P75 {

    public void sortColors(int[] nums) {
        int minPos = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[minPos] < nums[i]) {
                int temp = nums[minPos];
                nums[minPos] = nums[i];
                nums[i] = temp;
            }
        }
    }

}
