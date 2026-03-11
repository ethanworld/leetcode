package org.example.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 11:06
 * @Version: 1.0
 * @Desc :
 */
public class P78 {

    private HashMap<Integer, Boolean> map;
    private int max = 0;
    void dfs (List<List<Integer>> result, List<Integer> path) {
        result.add(new ArrayList<Integer>(path));
        if (path.size() == max) {
            return;
        }

        for (int num: map.keySet()) {
            if (map.get(num)) {
                continue;
            }
            // 去重剪枝：通过保证升序DFS
            if (!path.isEmpty() && path.getLast() > num) {
                continue;
            }
            map.put(num, true);
            path.add(num);
            dfs(result, path);
            path.removeLast();
            map.put(num, false);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
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
