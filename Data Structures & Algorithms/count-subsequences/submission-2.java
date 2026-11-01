class Solution {
    Integer[][] cache;

    public int numDistinct(String s, String t) {
        cache = new Integer[s.length()][t.length()];
        return dfs(s, 0, t, 0);
    }

    int dfs(String s, int ind, String t, int j) {

        if (j == t.length()) {
            return 1;
        }

        if (ind == s.length()) {
            return 0;
        }

        if (cache[ind][j] != null) {
            return cache[ind][j];
        }

        int skip = dfs(s, ind + 1, t, j);

        int take = 0;

        if (s.charAt(ind) == t.charAt(j)) {
            take = dfs(s, ind + 1, t, j + 1);
        }

        return cache[ind][j] = skip + take;
    }
}