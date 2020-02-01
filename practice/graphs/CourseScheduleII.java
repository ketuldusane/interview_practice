package graphs;

import java.util.*;

/**
 * Course Schedule II
 * <p>
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

public class CourseScheduleII {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if (numCourses <= 0 || prerequisites == null) {
      return new int[numCourses];
    }

    // Build an adj map and a degree map for topolocagical sorting
    HashMap<Integer, Set<Integer>> adj = new HashMap<>();
    HashMap<Integer, Integer> degree = new HashMap<>();

    // Set degree to 0 for each course
    for (int i = 0; i < numCourses; i++) {
      degree.put(i, 0);
    }

    // Traverse the 2d array and populate teh adj map and update the degree map
    for (int[] dep : prerequisites) {
      int course = dep[0];
      int prereq = dep[1];
      Set<Integer> set = adj.getOrDefault(course, new HashSet<>());
      set.add(prereq);
      adj.put(course, set);
      degree.put(prereq, degree.get(prereq) + 1);
    }

    // Perform topological sort
    Deque<Integer> queue = new ArrayDeque<>();
    for (int course : degree.keySet()) {
      if (degree.get(course) == 0) {
        queue.offer(course);
      }
    }

    int[] ans = new int[numCourses];
    int k = numCourses - 1;

    while (!queue.isEmpty()) {
      int course = queue.poll();
      ans[k] = course;
      k--;
      if (adj.containsKey(course)) {
        for (int prereq : adj.get(course)) {
          degree.put(prereq, degree.get(prereq) - 1);
          if (degree.get(prereq) == 0) {
            queue.offer(prereq);
          }
        }
      }
    }

    if (k != -1) {
      return new int[0];
    }

    return ans;
  }
}
