class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            mp.computeIfAbsent(src, k -> new ArrayList<>()).add(dst);
            mp.computeIfAbsent(dst, k -> new ArrayList<>()).add(src);

            // set.add(src);
            // set.add(dst);
        }
        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(visited, i, mp);
                components++;
            }
        }

        return components;
    }

    void dfs(Set<Integer> visited, int node, Map<Integer, List<Integer>> mp) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);

        if (mp.containsKey(node)) {
            for (int n : mp.get(node)) {
                dfs(visited, n, mp);
            }
        }
    }
}
