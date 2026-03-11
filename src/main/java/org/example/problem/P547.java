package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/11 8:27
 * @Version: 1.0
 * @Desc :
 */

import org.example.util.*;

public class P547 {

    void dfs(int[][] isConnected, int row) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[row][i] == 1) {
                isConnected[row][i] = 0;
                isConnected[i][row] = 0;
                dfs(isConnected, i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {

        int cnt = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    cnt++;
                    dfs(isConnected, i);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {

    }
}
