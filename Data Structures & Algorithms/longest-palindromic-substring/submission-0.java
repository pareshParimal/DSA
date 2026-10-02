class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        for (int i = len; i >= 1; i--) {
            for (int j = 0; j + i <= len; j++) {
                if (isPalindrome(j, j + i - 1, s)) {
                    return s.substring(j, j + i);
                }
            }
        }
        return "";
    }

    boolean isPalindrome(int st, int en, String s) {
        while (st < en) {
            if (s.charAt(st) != s.charAt(en)) {
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
