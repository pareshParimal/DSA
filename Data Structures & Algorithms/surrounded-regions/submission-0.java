class Solution {
    int ROW, COL;
    int[] hx = {-1, 0, 1, 0};
    int[] vy = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int row = board.length;
        ROW = row;
        int col = board[0].length;
        COL = col;
        boolean[][] edges = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, edges);
            dfs(board, i, col - 1, edges);
        }
        for (int i = 0; i < col; i++) {
            dfs(board, 0, i, edges);
            dfs(board, row - 1, i, edges);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!edges[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int row, int col, boolean[][] edges) {
        if (row < 0 || row >= ROW || col < 0 || col >= COL || edges[row][col]
            || board[row][col] == 'X') {
            return;
        }
        edges[row][col] = true;
        for (int i = 0; i < 4; i++) {
            dfs(board, row + hx[i], col + vy[i], edges);
        }
    }
}
