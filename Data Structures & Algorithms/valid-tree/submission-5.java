class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            mp.get(src).add(dest);
            mp.get(dest).add(src);
        }
        dfs(0, set, mp);
        return set.size() == n;
    }
    void dfs(int node, Set<Integer> set, Map<Integer, List<Integer>> mp) {
        set.add(node);
        for (int n : mp.get(node)) {
            if (!set.contains(n)) {
                dfs(n, set, mp);
            }
        }
    }
}
