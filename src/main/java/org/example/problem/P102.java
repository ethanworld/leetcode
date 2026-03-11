package org.example.problem;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 13:07
 * @Version: 1.0
 * @Desc :
 */
public class P102 {

    static class TreeNodeWrapper {
        TreeNode node;
        int level;
        TreeNodeWrapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<TreeNodeWrapper> queue = new ArrayList<>();
        queue.add(new TreeNodeWrapper(root, 0));
        List<List<Integer>> res = new ArrayList<>();

        int pos = 0;
        int lastLevel = 0;
        ArrayList<Integer> path = new ArrayList<>();
        while (pos < queue.size()) {
            TreeNodeWrapper head = queue.get(pos);
            if (head.node.left != null) {
                queue.add(new TreeNodeWrapper(head.node.left, head.level + 1));
            }
            if (head.node.right != null) {
                queue.add(new TreeNodeWrapper(head.node.right, head.level + 1));
            }
            if (lastLevel != head.level) {
                lastLevel = head.level;
                res.add(new ArrayList<>(path));
                path.clear();
            }
            path.add(head.node.val);
            pos++;
        }
        res.add(new ArrayList<>(path));
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        n1.left = n2;
        n1.right = n3;

        P102 p102 = new P102();
        p102.levelOrder(n1);

    }

}
