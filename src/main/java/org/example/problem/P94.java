package org.example.problem;
import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 15:33
 * @Version: 1.0
 * @Desc :
 */
public class P94 {

    void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        dfs(root.left, path);
        path.add(root.val);
        dfs(root.right, path);
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path);
        return path;
    }

}
