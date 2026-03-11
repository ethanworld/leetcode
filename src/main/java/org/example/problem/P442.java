package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 13:01
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class P442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            // 首次出现
            if (nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i);
            }
        }
        return result;
    }


}
