package org.example.problem;

import org.example.util.TreeNode;

import java.util.ArrayList;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 16:18
 * @Version: 1.0
 * @Desc :
 */
public class P129 {

    int sum;
    void dfs(TreeNode root, ArrayList<Integer> path) {
        if (root.left == null && root.right == null) {
            int cnt = 0;
            for (int i : path) {
                cnt  = cnt * 10 + i;
            }
            sum += cnt;
            return;
        }

        path.add(root.val);
        if (root.left != null) {
            dfs(root.left, path);
        }
        if (root.right != null) {
            dfs(root.right, path);
        }
        path.removeLast();
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, new ArrayList<>());
        return sum;
    }
}
