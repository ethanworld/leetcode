package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 13:28
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P687 {

    void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }
        dfs(node.left, path);
        path.add(node.val);
        dfs(node.right, path);
    }

    public int longestUnivaluePath(TreeNode root) {
        List<Integer> path = new ArrayList<Integer>();
        dfs(root, path);

        System.out.println(path);
        int[] dp = new int[path.size()];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < path.size(); i++) {
            if (path.get(i - 1) == path.get(i)) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res -1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        System.out.println(new P687().longestUnivaluePath(n1));
    }
}
