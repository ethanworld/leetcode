package org.example.problem;

import java.util.ArrayList;

/**
 * @author : ethan
 * @date : 2026/3/8 20:06
 * @Version: 1.0
 * @Desc :
 */
public class P827 {

    private int OFFSET = 10;
    private int area = 0;
    private int index = OFFSET;
    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 0) {
            return;
        }
        // 遍历过1记录为当前index
        grid[x][y] = index;
        area += 1;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    int check(int[][] grid, int x, int y) {
        int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] d : direction) {
            if (x+d[0] < 0 || x + d[0] > grid.length || y+d[1] < 0 || y + d[1] > grid[0].length) {
                continue;
            }
            if (grid[x+d[0]][y+d[1]] > 0) {}
            list.add(new int[]{x+d[0], y+d[1]});

        }
        // ....
        return 0;
    }

    public int largestIsland(int[][] grid) {
        ArrayList<Integer> islands = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 每次发起dfs，岛屿数量加1，因为dfs内部会将当前岛屿全部清理成水
                    area = 0;
                    dfs(grid, i, j);
                    islands.add(area);
                    index += 1;
                }
            }
        }
        // 。。。。
        return 0;


    }

}
