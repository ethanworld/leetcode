package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 9:33
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.util.Arrays;

public class P567 {

    public boolean checkInclusion(String s1, String s2) {

        int[] map = new int[26];
        Arrays.fill(map, -1);
        int zero_cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            int pos = s1.charAt(i) - 'a';
            if (map[pos] == -1) {
                zero_cnt++;
                map[pos]++;
            }
            map[pos]++;
        }

        int left = 0, right = 0;
        for (; right < s2.length(); right++) {
            if (zero_cnt == 0) {
                return true;
            }
            int pos = s2.charAt(right) - 'a';

            if (map[pos] > 0) {
                map[pos]--;
                if(map[pos] == 0) {
                    zero_cnt--;
                }
                continue;
            }
            if (map[pos] <= 0) {
                while (left < right) {
                    pos = s2.charAt(left) - 'a';
                    if (map[pos] == 0) {
                        zero_cnt++;
                    }
                    if (map[pos] >= 0) {
                        map[pos]++;
                    }
                    left++;
                }
                left = right + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P567 p = new P567();
//        System.out.println(p.checkInclusion("ab", "eidbaooo"));
//        System.out.println(p.checkInclusion("ab", "eidboaoo"));
        System.out.println(p.checkInclusion("adc", "dcda"));
    }
}
