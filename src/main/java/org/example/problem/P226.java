package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : ethan
 * @date : 2026/3/8 21:34
 * @Version: 1.0
 * @Desc :
 */
public class P226 {

    TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

}
