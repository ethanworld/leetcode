package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/10 17:13
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class P452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return (a[1] > b[1]) ? 1: -1;
            return (a[0] > b[0]) ? 1: -1;
        });
        int i = 0;
        int cnt = 0;
        long last = Long.MIN_VALUE;
        while (i < points.length) {
            // 如果当前i左侧大于上一个右侧，则需要射出一把弓箭
            if (points[i][0] > last) {
                cnt++;
                last = points[i][1];
            } else {
                // 射出的气球要选择能覆盖后续范围的，所以更新last
                last = Math.min(last, points[i][1]);
            }
            i++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        P452 p = new P452();
//        System.out.println(p.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
//        System.out.println(p.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
        System.out.println(p.findMinArrowShots(new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}}));
    }

}
