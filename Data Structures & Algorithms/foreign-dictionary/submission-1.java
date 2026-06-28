class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String str : words) {
            for (char c : str.toCharArray()) {
                adj.putIfAbsent(c, new ArrayList<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        //System.out.println("indegre size is "+ indegree.size());

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int firstLen = first.length();
            int secLen = second.length();

            if (firstLen > secLen
                && first.substring(0, secLen).equals(second.substring(0, secLen))) {
                return "";
            }

            int minLen = Math.min(firstLen, secLen);

            for (int j = 0; j < minLen; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    adj.get(first.charAt(j)).add(second.charAt(j));
                    indegree.put(second.charAt(j), indegree.get(second.charAt(j)) + 1) ;
                    break;
                }
            }
        }

        Queue<Character> bfsQueue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                bfsQueue.offer(c);
                //System.out.println("added in bfs queue "+ c);
            }
        }



        StringBuilder sb = new StringBuilder();

        while (!bfsQueue.isEmpty()) {
            char c = bfsQueue.poll();
            sb.append(c);
           // System.out.println("sb till now is "+ String.valueOf(sb));
            for (char ch : adj.get(c)) {
                indegree.put(ch, indegree.get(ch) - 1);
                if (indegree.get(ch) == 0) {
                   // System.out.println("addig in queue "+ ch);
                    bfsQueue.offer(ch);
                }
            }
        }

        if (indegree.size() != sb.length()) {
            return "";
        }

        return sb.toString();
    }
}
