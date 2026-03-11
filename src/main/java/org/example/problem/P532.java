package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 23:05
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.Arrays;
import java.util.HashMap;

public class P532 {

    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int cnt = 0;
        Arrays.sort(nums);
        int last = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == last) {
                if (map.get(num) > 1 && k == 0) {
                    map.put(num, 1);
                    cnt++;
                }
                continue;
            }
            last = num;
            if (k != 0 && map.containsKey(num + k)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        P532 p532 = new P532();
        System.out.println(p532.findPairs(new int[]{1, 3, 1, 4, 5}, 0));
    }
}
