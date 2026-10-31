class Solution {
    Integer [][]memo ;
    int count = 0;
    int row, col;
    public int uniquePaths(int m, int n) {
        row = m;
        col = n;
        memo = new Integer[row][col];
        return dfs(0, 0);
    }
    int dfs(int x, int y) {
        if (x >= row || y >= col) {
            return 0;
        }
        if (x == row - 1 && y == col - 1) {
            return 1;
        }
        if(memo[x][y]!=null){
            return memo[x][y] ;
        }
        memo[x][y]= dfs(x + 1, y) + dfs(x, y + 1);
        return memo[x][y];
    }
}
