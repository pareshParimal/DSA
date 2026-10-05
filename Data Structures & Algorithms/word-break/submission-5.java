class Solution {
    Boolean[] cache;
    public boolean wordBreak(String s, List<String> wordDict) {
        cache = new Boolean[s.length() + 1];
        return dfs(s, wordDict, 0);
    }

    boolean dfs(String s, List<String> dict, int i) {
        if (i >= s.length()) {
            return true;
        }
        if (cache[i] != null) {
            return cache[i];
        }
        for (String st : dict) {
            if (i + st.length() <= s.length() && s.substring(i, i + st.length()).equals(st)) {
                if (dfs(s, dict, i + st.length())) {
                    cache[i] = true;
                    return true;
                }
            }
        }
        cache[i] = false;
        return false;
    }
}
