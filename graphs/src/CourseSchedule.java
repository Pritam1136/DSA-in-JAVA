import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && isCyclic(i, visited, recStack, graph)) {
                return false;
            }
        }
        return true;
    }

    private boolean isCyclic(int node, boolean[] visited, boolean[] recStack, List<List<Integer>> graph) {
        if (recStack[node]) return true;
        if (visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (isCyclic(neighbor, visited, recStack, graph)) {
                return true;
            }
        }

        recStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 1}, {3, 2}};
        System.out.println("Can finish all courses: " + solution.canFinish(numCourses, prerequisites)); // Output should be true
    }
}
