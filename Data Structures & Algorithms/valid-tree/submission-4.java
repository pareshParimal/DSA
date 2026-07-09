class Solution {
    public boolean validTree(int n, int[][] edges) {
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

        return dfs(0,-1, mp, set) && set.size() == n;
    }

    boolean dfs(int node,int parent, Map<Integer, List<Integer>> mp, Set<Integer> set) {
        if (set.contains(node)) {
            return false;
        }
        set.add(node);
        for (int n : mp.get(node)) {
            if(n==parent){
                continue;
            }
            if(!dfs(n,node, mp, set)){
                return false;
            }
        }
        return true;
    }
}
