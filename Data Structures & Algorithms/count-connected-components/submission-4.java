class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            int srcRoot = find(parent, src);
            int dstRoot = find(parent, dst);

            if (srcRoot != dstRoot) {
                if (size[srcRoot] > size[dstRoot]) {
                    parent[dstRoot] = srcRoot;
                    size[srcRoot] += size[dstRoot];
                } else {
                    parent[srcRoot] = dstRoot;
                    size[dstRoot] += size[srcRoot];
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent, parent[i]));
        }
        return set.size();
    }

    private int find(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = find(parent, parent[node]);
        }

        return parent[node];
    }
}
