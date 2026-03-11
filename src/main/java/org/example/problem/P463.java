package org.example.problem;

/**
 * @author : ethan
 * @date : 2026/3/8 20:16
 * @Version: 1.0
 * @Desc :
 */
public class P463 {

    private int sum = 0;
    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            sum +=1;
            return;
        }
        if (grid[x][y] != 1) {
            if (grid[x][y] == 0) {
                sum +=1;
            }
            return;
        }

        // 遍历过的1标记为2
        grid[x][y] = 2;

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }

    public int islandPerimeter(int[][] grid) {
        sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // 只有1个岛屿
                    dfs(grid, i, j);
                    return sum;
                }
            }
        }
        return 0;
    }

}
