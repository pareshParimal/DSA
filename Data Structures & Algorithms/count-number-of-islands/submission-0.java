class Solution {
    int[] hx = {-1, 0, 1, 0};
    int[] vy = {0, -1, 0, 1};
    int length;
    int breadth;

    public int numIslands(char[][] grid) {
        length = grid.length;
        breadth = grid[0].length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= length || y < 0 || y >= breadth || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + hx[i], y + vy[i]);
        }
    }
}
