package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 14:51
 * @Version: 1.0
 * @Desc :
 */
public class P104 {

    int dfs(TreeNode node, int level) {
        if (node == null) {
            return level;
        }

        return Integer.max(dfs(node.left, level+1), dfs(node.right, level+1));
    }

    public int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n2.left = n3;

        P104 p104 = new P104();
        int i = p104.maxDepth(n1);
        System.out.println(i);
    }

}
