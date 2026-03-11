package org.example.problem;

/**
 * @author : zhangxueqiu
 * @date : 2026/3/8 16:47
 * @Version: 1.0
 * @Desc :
 */
public class P130 {

    void bfs(char[][] board, int x, int y) {

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }

        // 如果是'O'，表示需要继续被着色，如果不是'O'表示不该被着色或者已经着色成W
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'W';

        int[][] direction = new int[][] {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : direction) {
            bfs(board, x + d[0], y + d[1]);
        }

    }

    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从边缘开始BFS，将关联的O替换成W
                if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                    if (board[i][j] == 'O' || board[i][j] == 'W') {
                        bfs(board, i, j);
                    }
                }
            }
        }


        // 遍历整个矩阵，将剩余的O替换成X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // 遍历整个矩阵，将W还原成O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'W') {
                    board[i][j] = 'O';
                }
            }
        }

        return;
    }

}
