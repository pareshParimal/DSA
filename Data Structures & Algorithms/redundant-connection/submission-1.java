class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int []size = new int[n];
        Stack<int[]> stk = new Stack<>();
        for(int i =0;i<n;i++){
            parent[i]= i;
            size[i]=1;
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];

            int srcParent = find(parent, src);
            int dstParent = find(parent, dst);

            if (srcParent == dstParent) {
                stk.add(new int[]{src,dst});
            }else{
                if(size[srcParent]>size[dstParent]){
                    parent[dstParent]=srcParent;
                    size[srcParent]+=size[dstParent];

                }else{
                    parent[srcParent]=dstParent;
                    size[dstParent]+=size[srcParent];
                }
            }
        }

        return stk.peek();
    }

    int find(int[]parent, int node){
        if(parent[node]!= node){
            parent[node]=find(parent, parent[node]);
        }
        return parent[node];
    }
}
