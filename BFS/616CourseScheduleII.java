public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        //initialize edges
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        //update the edges and degree

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue queue = new LinkedList();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        int[] res = new int[numCourses];

        while (!queue.isEmpty()) {
            int course = (int) queue.poll();
            res[count] = course;
            count++;

            int size = edges[course].size();
            for (int i = 0; i < size; i++) {
                int pointer = (int) edges[course].get(i);
                degree[pointer]--;
                if (degree[pointer] == 0) {
                    queue.offer(pointer);
                }
            }
        }
        if (count == numCourses) {
            //Collections.reverse(Arrays.asList(res));
            return res;
        }else {
            return new int[0];
        }
    }
}
