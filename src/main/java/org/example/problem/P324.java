package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/9 14:55
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.ArrayList;

public class P324 {

    public void wiggleSort(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort(Integer::compare);

        // 偶数位置，降序放在小一半数据，降序是保障边界相等的场景
        int cnt = (nums.length - 1) / 2;
        for (int idx = 0; idx < nums.length; idx+=2) {
            nums[idx] = list.get(cnt);
            cnt--;
        }

        // 奇数位置，降序放在大一半数据
        cnt = nums.length - 1;
        for (int idx = 1; idx < nums.length; idx+=2) {
            nums[idx] = list.get(cnt);
            cnt--;
        }

        System.out.println(list);
    }

    public static void main(String[] args) {
        P324 p = new P324();
        p.wiggleSort(new int[]{1,3,2,2,3,1});
    }

}
