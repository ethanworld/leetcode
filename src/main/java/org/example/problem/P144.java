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
public class P144 {

    void dfs(TreeNode root, List<Integer> path) {
        if (root == null) {
            return;
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path);
        return path;
    }

}
