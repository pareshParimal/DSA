class Solution {
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    int row, col;
    boolean[][] visited;
    Integer[][]cache;
    int currMax;
    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        col = matrix[0].length;
        cache = new Integer[row+1][col+1];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                visited = new boolean[row][col];
                currMax = 0;
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max+1;
    }

    int dfs(int[][] matrix, int m, int n) {
        if (m >= row || n >= col || m < 0 || m >= row || n < 0 || n >= col) {
            return 0;
        }

        if(cache[m][n]!=null){
            return cache[m][n];
        }
        int currMax = 0;
        for (int i = 0; i < 4; i++) {
            if (m + x[i] >= 0 && m + x[i] < row && n + y[i] >= 0 && n + y[i] < col
                && matrix[m + x[i]][n + y[i]] > matrix[m][n] && !visited[m + x[i]][n + y[i]]) {
                visited[m + x[i]][n + y[i]] = true;
                currMax = Math.max(currMax, 1 + dfs(matrix, m + x[i], n + y[i]));
                visited[m + x[i]][n + y[i]] = false;
            }
        }
        cache[m][n]= currMax;

        return currMax;
    }
}
