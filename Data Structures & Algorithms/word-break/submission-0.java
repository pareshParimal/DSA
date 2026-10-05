class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        q.offer(sb.toString());
        Set<String> set = new HashSet<>();
        while (!q.isEmpty()) {
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                String st = q.poll();
                for (int j = 0; j < wordDict.size(); j++) {
                    String str = st + wordDict.get(j);
                    if (str.equals(s)) {
                        return true;
                    }
                    int index = s.indexOf(str);
                    if (index == 0 && !set.contains(str)) {
                        q.offer(str);
                    }
                    set.add(str);
                }
            }
        }
        return false;
    }
}
