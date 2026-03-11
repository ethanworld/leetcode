package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 14:51
 * @Version: 1.0
 * @Desc :
 */
public class P111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right= minDepth(root.right);

        if (left == 0) {
            return right;
        }
        if (right == 0) {
            return left;
        }


        return Integer.min(left, right) + 1;
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.right = n2;
        n2.right = n3;

        P111 p104 = new P111();
        int i = p104.minDepth(n1);
        System.out.println(i);
    }

}
