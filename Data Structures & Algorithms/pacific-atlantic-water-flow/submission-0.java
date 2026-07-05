class Solution {
    int[] hx = new int[] {-1, 0, 1, 0};
    int[] vy = new int[] {0, 1, 0, -1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

       List<List<Integer>> result = new ArrayList<>();

    // If it's a 1D strip, every cell touches both oceans.
    // We just return all the grid coordinates.
    if (row == 1 || col == 1) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.add(List.of(i, j));
            }
        }
        return result;
    }
        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> aq = new LinkedList<>();

        boolean[][] pv = new boolean[row][col];
        boolean[][] av = new boolean[row][col];

        int[][] count = new int[row][col];

        for (int i = 0; i < row; i++) {
            pq.offer(new int[] {i, 0});
            aq.offer(new int[] {i, col - 1});
            count[i][0]++;
            count[i][col - 1]++;
            pv[i][0] = true;
            av[i][col - 1] = true;
        }

        for (int j = 0; j < col; j++) {
            aq.offer(new int[] {row - 1, j});
            pq.offer(new int[] {0, j});
            count[row - 1][j]++;
            count[0][j]++;
            pv[0][j] = true;
            av[row - 1][j] = true;
        }

        count[0][0]=1;
        count[row-1][col-1]=1;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];

            for (int i = 0; i < 4; i++) {
                int newx = x + hx[i];
                int newy = y + vy[i];

                if (newx >= 0 && newx < row && newy >= 0 && newy < col && !pv[newx][newy]
                    && heights[newx][newy] >= heights[x][y]) {
                    count[newx][newy]++;
                    pv[newx][newy] = true;
                    pq.offer(new int[] {newx, newy});
                }
            }
        }

        while (!aq.isEmpty()) {
            int[] cell = aq.poll();
            int x = cell[0];
            int y = cell[1];

            for (int i = 0; i < 4; i++) {
                int newx = x + hx[i];
                int newy = y + vy[i];

                if (newx >= 0 && newx < row && newy >= 0 && newy < col && !av[newx][newy]
                    && heights[newx][newy] >= heights[x][y]) {
                    count[newx][newy]++;
                    av[newx][newy] = true;
                    aq.offer(new int[] {newx, newy});
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (count[i][j] >= 2) {
                    list.add(List.of(i, j));
                }
            }
        }
        return list;
    }
}
