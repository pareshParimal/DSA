class Solution {
    int[] hx = new int[] {-1, 0, 1, 0};
    int[] vy = new int[] {0, -1, 0, 1};
    public void islandsAndTreasure(int[][] grid) {
        int len = grid.length;
        int br = grid[0].length;
        boolean[][] visited = new boolean[len][br];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < br; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int level = 1;
        while (!q.isEmpty()) {
            int curr_size = q.size();
            for (int j = 0; j < curr_size; j++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int i = 0; i < 4; i++) {
                    if (x + hx[i] >= 0 && x + hx[i] < len && y + vy[i] >= 0 && y + vy[i] < br
                        && !visited[x + hx[i]][y + vy[i]]
                        && grid[x + hx[i]][y + vy[i]] == Integer.MAX_VALUE) {
                        grid[x + hx[i]][y + vy[i]] = level;
                        visited[x + hx[i]][y + vy[i]] = true;
                        q.offer(new int[] {x + hx[i], y + vy[i]});
                    }
                }
            }
            level++;
        }
    }
}
