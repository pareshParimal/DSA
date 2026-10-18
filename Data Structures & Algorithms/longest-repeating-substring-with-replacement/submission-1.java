class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int len = s.length();
        int i = 0, j = 0;
        int maxFreq = 0;
        int maxLen = Integer.MIN_VALUE;
        boolean flag = true;
        while (j < len) {
            if (flag) {
                count[s.charAt(j) - 'A']++;
            }
            maxFreq = 0;
            for (int m = 0; m < 26; m++) {
                maxFreq = Math.max(maxFreq, count[m]);
            }
            //System.out.println("maxFreq is" + maxFreq);
            int lenSub = (j - i + 1);
            //System.out.println("lenSub  is " + lenSub + " j is " + j);
            if (lenSub - maxFreq <= k) {
                maxLen = Math.max(lenSub, maxLen);
                //System.out.println("updating maxLen and new val is " + maxLen + " and i is " + i);
                //System.out.println("len is " + lenSub + " i is  " + i + " and j is " + j);
                j++;
                flag = true;
            } else {
                flag =false;
                count[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return maxLen;
    }
}
