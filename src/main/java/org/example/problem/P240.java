package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/9 14:15
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

public class P240 {


    public boolean searchMatrix(int[][] matrix, int target) {

        int i = 0, j = matrix[i].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
                continue;
            }
            if (matrix[i][j] < target) {
                i++;
                continue;
            }
        }
        return false;
    }


}
