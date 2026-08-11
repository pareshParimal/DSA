class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length!= n-1){
            return false;
        }
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            int rootSrc= find(parent, src);
            int rootDest = find(parent , dest);

            if(rootSrc==rootDest){
                return false ;
            }

            parent[rootSrc]= rootDest ;

        }
        return true;
    }

    private int  find(int[]parent , int node){
        if(parent[node]!= node){
            parent[node]= find(parent,parent[node]);
        }
        return parent[node];
    }
}
