package org.example.util;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 12:54
 * @Version: 1.0
 * @Desc :
 */
public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     public TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
