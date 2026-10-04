class Solution {
    int len;
    Integer[] cache;
    public int numDecodings(String s) {
        len = s.length();
        cache = new Integer[len+1];
        return dfs(s, 0);
    }

    int dfs(String s, int ind) {
        if (cache[ind] != null) {
            return cache[ind];
        }
        if (ind >= len) {
            return 1;
        }
        if (s.charAt(ind) == '0') {
            return 0;
        }
        int res = dfs(s, ind + 1);
        if (ind < len - 1) {
            if (s.charAt(ind) == '1' || (s.charAt(ind) == '2' && s.charAt(ind + 1) < '7')) {
                res += dfs(s, ind + 2);
            }
        }
        cache[ind] = res;
        return res;
    }
}
