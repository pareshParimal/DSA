class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> dependencies = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            dependencies.computeIfAbsent(prerequisite[1], k -> new ArrayList<>())
                .add(prerequisite[0]);
        }

        Queue<Integer> courseQ = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                courseQ.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int count = 0;
        while (!courseQ.isEmpty()) {
            int courseTaken = courseQ.poll();
            order[count++] = courseTaken;
            if (dependencies.containsKey(courseTaken)) {
                for (int dependentCourse : dependencies.get(courseTaken)) {
                    indegree[dependentCourse]--;
                    if (indegree[dependentCourse] == 0) {
                        courseQ.offer(dependentCourse);
                    }
                }
            }
        }

        return count == numCourses ? order : new int[] {};
    }
}
