class Solution {
    int[] hx = new int[] {-1, 0, 1, 0};
    int[] vy = new int[] {0, 1, 0, -1};
    public int orangesRotting(int[][] grid) {
        int len = grid.length;
        int br = grid[0].length;
        int fresh = 0;
        boolean flag = false;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < br; j++) {
                if (grid[i][j] == 2) {
                    flag = true;
                    q.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int level = 0;

        while (!q.isEmpty()) {
            int curr_qsize = q.size();
            for (int i = 0; i < curr_qsize; i++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                for (int j = 0; j < 4; j++) {
                    if (x + hx[j] >= 0 && x + hx[j] < len && y + vy[j] >= 0 && y + vy[j] < br
                        && grid[x + hx[j]][y + vy[j]] == 1) {
                        grid[x + hx[j]][y + vy[j]] = 2;
                        q.offer(new int[] {x + hx[j], y + vy[j]});
                        fresh--;
                    }
                }
            }
            level++;
        }

        if (!flag) {
            return fresh == 0 ? 0 : -1;
        }

        return fresh == 0 ? level - 1 : -1;
    }
}
