package org.example.problem;

import org.example.util.*;

/**
 * @author : ethan
 * @date : 2026/3/9 13:16
 * @Version: 1.0
 * @Desc :
 */
public class P236 {

    TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return  dfs(root, p, q);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        P236 p236 = new P236();
        TreeNode root = p236.lowestCommonAncestor(n1, n1, n2);
    }


}
