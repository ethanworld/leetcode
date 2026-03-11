package org.example.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 10:48
 * @Version: 1.0
 * @Desc :
 */
public class P47 {

    private HashMap<Integer, Integer> map;
    private int max = 0;
    void dfs (List<List<Integer>> result, List<Integer> path) {

        if (path.size() == max) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int num: map.keySet()) {
            if (map.get(num) == 0) {
                continue;
            }
            map.put(num, map.get(num) - 1);
            path.add(num);
            dfs(result, path);
            path.removeLast();
            map.put(num, map.get(num) + 1);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        max = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path);
        return result;
    }
}
