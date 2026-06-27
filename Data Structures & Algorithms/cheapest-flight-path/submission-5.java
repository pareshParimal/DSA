class Solution {
    int limit, ans = Integer.MAX_VALUE, cost = 0, dest;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> mp = new HashMap<>();
        limit = k;
        dest = dst;
        for (int[] arr : flights) {
            int s = arr[0];
            int d = arr[1];
            int w = arr[2];

            mp.computeIfAbsent(s, p -> new ArrayList<>()).add(new int[] {d, w});
        }

        dfs(mp, src, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    void dfs(Map<Integer, List<int[]>> mp, int src, int steps) {
        if (steps > limit + 1 || (cost >ans)) {
            return;
        }

        // System.out.println("cost is "+cost + " src is "+src+" steps is "+ steps);

        if (src == dest) {
            ans = Math.min(ans, cost);
            return;
        }

        if ( !mp.containsKey(src)){
            return ;
        }
            for (int i = 0; i < mp.get(src).size(); i++) {
                cost += mp.get(src).get(i)[1];
                dfs(mp, mp.get(src).get(i)[0], steps + 1);
                cost -= mp.get(src).get(i)[1];
            }
    }
}
