package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 9:08
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

public class P424 {

    public int characterReplacement(String s, int k) {
        // 滑窗内维护一个窗口
//        int left = 0, right = 0;
//        // nums数组实时维护当前窗口各个字母出现的次数，窗口内除最大次数的其他字母都是需要替换的
//        int[] nums = new int[26];
//        // max记录历史过程最大的窗口大小
//        int max = 0;
//
//        for (; right < s.length(); right++) {
//            int idx = s.charAt(right) - 'A';
//            nums[idx]++;
//            max = Math.max(max, nums[idx]);
//
//            // 滑窗过程，不关心left和right字母是啥，只关心吃掉right后，跟max相比k是否足够
//            // 如果吃掉right后，k足够，说明right就是目前次数最大的字母，则left无需移动
//            // 如果吃掉right后，k不满足，right自身需要消耗一个k名额，不论left是否
//            if (right - left + 1 - max > k) {
//
//            }
//
//
//        }
        return 0;

    }

}
