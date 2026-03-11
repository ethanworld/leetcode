package org.example.problem;

import org.example.util.TreeNode;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 15:21
 * @Version: 1.0
 * @Desc :
 */
public class P112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }

        if (targetSum == 0) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}
