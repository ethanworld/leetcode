package src;

import util.UnitTest;

/**
 * P3
 * 题目：3. 无重复字符的最长子串
 * 算法：双指针
 */
public class P3 {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int max_len = 0;
        // 双指针
        int left = 0, right = 0;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            // 右指针在map中存在重复字符
            if (map[rightChar] == 1) {
                // 左指针滑动，直至找到重复字符
                while (true) {
                    char leftChar = s.charAt(left);
                    left++;
                    if (leftChar == rightChar) {
                        break;
                    }
                    // 找到重复字符之前的字符从map中清除
                    map[leftChar] = 0;
                }
            } else {
                // 右指针未出现重复字符，则map记录
                map[rightChar] = 1;
            }
            max_len = Integer.max(max_len, right - left + 1);
            right++;
        }
        return max_len;
    }

    public static void main(String[] args) {
        P3 p3 = new P3();
        int rst = 0;
        rst = p3.lengthOfLongestSubstring("sdfds");
        UnitTest.EXPERT_EQ(rst, 3);

        rst = p3.lengthOfLongestSubstring("abcabcbb");
        UnitTest.EXPERT_EQ(rst, 3);

        rst = p3.lengthOfLongestSubstring("bbbbb");
        UnitTest.EXPERT_EQ(rst, 1);

        rst = p3.lengthOfLongestSubstring("pwwkew");
        UnitTest.EXPERT_EQ(rst, 3);
    }
}