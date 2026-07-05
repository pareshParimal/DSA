class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        // for (int[] prerequisite : prerequisites) {
        //     indegree[prerequiste[0]]++;
        // }
        List<List<Integer>> dependencies = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            dependencies.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            dependencies.get(prerequisite[1]).add(prerequisite[0]);
        }

        Queue<Integer> courseQ = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                courseQ.offer(i);
            }
        }

        int[] courseSequence = new int[numCourses];
        int count = 0;

        while (!courseQ.isEmpty()) {
            int currCourse = courseQ.poll();
            courseSequence[count++] = currCourse;
            for (int dependents : dependencies.get(currCourse)) {
                indegrees[dependents]--;
                if (indegrees[dependents] == 0) {
                    courseQ.offer(dependents);
                }
            }
        }

        if (count == numCourses) {
            return courseSequence;
        }

        return new int[] {};
    }
}
