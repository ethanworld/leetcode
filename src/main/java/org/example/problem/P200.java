package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/8 20:06
 * @Version: 1.0
 * @Desc :
 */
public class P200 {

    void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        // 遍历过1记录为0
        grid[x][y] = '0';

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    public int numIslands(char[][] grid) {

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    // 每次发起dfs，岛屿数量加1，因为dfs内部会将当前岛屿全部清理成水
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

}
