class Solution {
    int length, breadth;
    int maxArea = Integer.MIN_VALUE;
    int area = 0;
    int[] hx = {-1, 0, 1, 0};
    int[] hy = {0, -1, 0, 1};
    public int maxAreaOfIsland(int[][] grid) {
        length = grid.length;
        breadth = grid[0].length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < breadth; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return Math.max(maxArea,area);
    }

    void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= length || y < 0 || y >= breadth || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        area++;
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + hx[i], y + hy[i]);
        }
    }
}
