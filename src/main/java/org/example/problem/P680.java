package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 12:41
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

public class P680 {

    public boolean find(String s, int cnt) {
        if (cnt < 0) {
            return false;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 两种创建都需要跑一把，取两者或结果
                return find(s.substring(left + 1, right + 1), cnt - 1) || find(s.substring(left, right), cnt - 1);
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        return find(s, 1);
    }

    public static void main(String[] args) {
        P680 p = new P680();
        System.out.println(p.validPalindrome("cbbcc"));
    }
}
