package graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Is Graph Bipartite?
 *
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that
 * every edge in the graph has one node in A and another node in B.
 *
 * The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j
 * exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i]
 * does not contain i, and it doesn't contain any element twice.
 *
 * Example 1:
 * Input: [[1,3], [0,2], [1,3], [0,2]]
 * Output: true
 * Explanation:
 * The graph looks like this:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * We can divide the vertices into two groups: {0, 2} and {1, 3}.
 * Example 2:
 * Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * Output: false
 * Explanation:
 * The graph looks like this:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * We cannot find a way to divide the set of nodes into two independent subsets.
 */

public class IsGraphBipartite {
  // use dfs
  // color the graph and check if neighbor color matches node color

  public boolean isBipartite(int[][] graph) {
    int[] color = new int[graph.length];
    Arrays.fill(color, -1);
    for (int i = 0; i < graph.length; i++) {
      if (color[i] == -1) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(i);
        color[i] = 0;
        while (!stack.isEmpty()) {
          int k = stack.pop();
          for (int neighbor : graph[k]) {
            if (color[neighbor] == -1) {
              stack.push(neighbor);
              color[neighbor] = color[k] ^ 1;
            } else if (color[neighbor] == color[k]) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }
}
