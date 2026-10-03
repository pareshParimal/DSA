class Solution {
    public int countSubstrings(String s) {
        int palindromeCount = 0;
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            // odd length palindromes

            int left = i;
            int right = i;

            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                palindromeCount++;
                left--;
                right++;
            }
            // even length

            left = i;
            right = i + 1;
            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                palindromeCount++;
                left--;
                right++;
            }
        }
        return palindromeCount;
    }
}
