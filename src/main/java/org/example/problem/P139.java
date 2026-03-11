package org.example.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : ethan
 * @date : 2026/3/8 17:11
 * @Version: 1.0
 * @Desc :
 */
public class P139 {

//    boolean dfs(String s, List<String> wordDict) {
//        if (s.isEmpty()) {
//            return true;
//        }
//
//        for (String word : wordDict) {
//            if (!s.startsWith(word)) {
//                continue;
//            }
//            if (dfs(s.substring(word.length()), wordDict)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//        return dfs(s, wordDict);
//    }

    public boolean wordBreak(String s, List<String> wordDict) {

        //dp记录0-索引位置的子串能否被拼接，默认false
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // 从0-i的子串是否能被拼接：dp[j]可以被拼接 + j-i之间能查询
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        P139 p139 = new P139();
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        System.out.println(p139.wordBreak("leetcode", words));
    }

}
