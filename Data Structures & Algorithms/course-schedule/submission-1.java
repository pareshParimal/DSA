class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            mp.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int coursesTaken = 0;
        while (!q.isEmpty()) {
            int courseTaken = q.poll();
            coursesTaken++;
            if (mp.containsKey(courseTaken)) {
                for (int dependentCourse : mp.get(courseTaken)) {
                    indegree[dependentCourse]--;
                    if (indegree[dependentCourse] == 0) {
                        q.offer(dependentCourse);
                    }
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
