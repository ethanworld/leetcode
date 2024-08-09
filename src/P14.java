package src;

/**
 * P14
 * 题目：14. 最长公共前缀
 * 算法：
 */
public class P14 {
    public String longestCommonPrefix(String[] strs) {
        int max = 0;
        // 列比较
        while (max < strs[0].length()) {
            char ch = strs[0].charAt(max);
            for (int i = 1; i < strs.length; i++) {
                if (max == strs[i].length() || ch != strs[i].charAt(max)) {
                    return strs[0].substring(0, max);
                }
            }
            max++;
        }
        return strs[0].substring(0, max);
    }
}
