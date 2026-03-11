package org.example.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 10:40
 * @Version: 1.0
 * @Desc :
 */
public class P46 {

    private HashMap<Integer, Boolean> map;
    private int max = 0;
    void dfs (List<List<Integer>> result, List<Integer> path) {

        if (path.size() == max) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int num: map.keySet()) {
            if (map.get(num)) {
                continue;
            }
            map.put(num, true);
            path.add(num);
            dfs(result, path);
            path.removeLast();
            map.put(num, false);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }
        max = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path);
        return result;
    }
}
