class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            int rootSrc = find(parent, edge[0]);
            int rootDst = find(parent, edge[1]);

            if (rootSrc == rootDst) {
                return false;
            }

            if (size[rootSrc] > size[rootDst]) {
                parent[rootDst] = rootSrc;
                size[rootSrc] += size[rootDst];
            } else {
                parent[rootSrc] = rootDst;
                size[rootDst] += size[rootSrc];
            }
        }

        return true;
    }

    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
