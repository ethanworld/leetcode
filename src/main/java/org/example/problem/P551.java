package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 9:19
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

public class P551 {

    public boolean checkRecord(String s) {

        int absent = 0;
        int late = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    absent++;
                    late = 0;
                    break;
                case 'L':
                    late++;
                    break;
                default:
                    late = 0;
            }
            if (absent >= 2 || late >= 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
