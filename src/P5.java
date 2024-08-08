package src;

import util.UnitTest;

/**
 * P5
 * 题目：5. 最长回文子串
 * 算法：动态规划
 */
public class P5 {
    
    public String longestPalindrome(String s) {
        int length = s.length();
       int[][] dp = new int[length][length];
       int start = 0;
       int maxLen = 1;
       // 最关键的是这里的遍历方式
       // right作为外循环，left作为内循环，right从0开始 --> 保证left->right中的子字符串一定都已经遍历过
       for (int right = 0; right < length; right++) {
           for (int left = 0; left <= right; left++) {
               if (left == right) {
                   dp[left][right] = 1;
               } else if (s.charAt(left) == s.charAt(right) && (left + 1 == right || dp[left + 1][right-1] == 1)) {
                   dp[left][right] = 1;
                   if (right - left + 1 > maxLen) {
                       maxLen = right - left +1;
                       start = left;
                   }
               }
           }
       }
       return s.substring(start, start + maxLen);
   }

   public static void main(String[] args) {
        P5 p5 = new P5();
        String rst = null;
        rst = p5.longestPalindrome("babad");
        UnitTest.EXPERT_EQ(rst, "bab");

        rst = p5.longestPalindrome("cbbd");
        UnitTest.EXPERT_EQ(rst, "bb");

        rst = p5.longestPalindrome("bbbbb");
        UnitTest.EXPERT_EQ(rst, "bbbbb");

   }
}
