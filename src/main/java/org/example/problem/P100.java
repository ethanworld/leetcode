package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 12:55
 * @Version: 1.0
 * @Desc :
 */
public class P100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
