class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> dependencies = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            dependencies.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            dependencies.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> courseQ = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                courseQ.offer(i);
            }
        }
        int coursesTaken = 0;
        while (!courseQ.isEmpty()) {
            int currCourse = courseQ.poll();
            coursesTaken++;
            for (int dependentCourse : dependencies.get(currCourse)) {
                indegree[dependentCourse]--;
                if (indegree[dependentCourse] == 0) {
                    courseQ.offer(dependentCourse);
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
