package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 13:03
 * @Version: 1.0
 * @Desc :
 */
public class P101 {

    boolean scan(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return scan(t1.left, t2.right) && scan(t1.right, t2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        return scan(root, root);
    }

}
