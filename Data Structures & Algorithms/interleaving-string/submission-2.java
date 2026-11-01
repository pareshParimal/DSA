class Solution {
    int len;
    int len1, len2;
    Boolean[][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        len = s3.length();
        len1 = s1.length();
        len2 = s2.length();
        cache = new Boolean[len1 + 1][len2 + 1];
        if (s1.length() + s2.length() != len) {
            return false;
        }

        return dfs(0, 0, 0, s1, s2, s3);
    }

    boolean dfs(int i, int j, int k, String s1, String s2, String s3) {
        if (k == len) {
            return j == len2 && i == len1;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if ((i < len1 && k < len) && s1.charAt(i) == s3.charAt(k)) {
            if (dfs(i + 1, j, k + 1, s1, s2, s3)) {
                cache[i][j] = true;
                return cache[i][j];
            }
        }

        if ((j < len2 && k < len) && s2.charAt(j) == s3.charAt(k)) {
            if (dfs(i, j + 1, k + 1, s1, s2, s3)) {
                cache[i][j] = true;
                return cache[i][j];
            }
        }
        cache[i][j] = false;
        return false;
    }
}
