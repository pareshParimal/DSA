class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount ==0){
            return 0;
        }
        // bfs
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[amount + 1];
        q.add(0);
        visited[0] = true;
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int j = 0; j < coins.length; j++) {
                    if (curr + coins[j] == amount) {
                        return ans;
                    }
                    if (curr + coins[j] > amount || visited[curr + coins[j]]) {
                        continue;
                    }
                    visited[curr + coins[j]] = true;
                    q.add(curr+coins[j]);
                }
            }
        }
        return -1;
    }
}
