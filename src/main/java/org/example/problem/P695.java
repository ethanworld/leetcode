package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/8 20:06
 * @Version: 1.0
 * @Desc :
 */
public class P695 {

    private int area = 0;
    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == 0) {
            return;
        }
        // 遍历过1记录为0
        grid[x][y] = 0;
        area += 1;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {

        int max_area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 每次发起dfs，岛屿数量加1，因为dfs内部会将当前岛屿全部清理成水
                    area = 0;
                    dfs(grid, i, j);
                    max_area = Math.max(max_area, area);
                }
            }
        }
        return max_area;
    }

}
