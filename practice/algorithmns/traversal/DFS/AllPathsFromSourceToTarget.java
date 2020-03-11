package algorithmns.traversal.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * All Paths from Source to target
 * <p>
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any
 * order.
 * <p>
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for
 * which the edge (i, j) exists.
 * <p>
 * Example:
 * Input: [[1,2], [3], [3], []]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Note:
 * <p>
 * The number of nodes in the graph will be in the range [2, 15].
 * You can print different paths in any order, but you should keep the order of nodes inside one path.
 */

public class AllPathsFromSourceToTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    temp.add(0);
    dfs(ans, graph, temp, 0);
    return ans;
  }

  private void dfs(List<List<Integer>> ans, int[][] graph, List<Integer> temp, int node) {
    if (node == graph.length - 1) {
      List<Integer> l = new ArrayList<>(temp);
      ans.add(l);
      return;
    }

    for (int neighbor : graph[node]) {
      temp.add(neighbor);
      dfs(ans, graph, temp, neighbor);
      temp.remove(temp.size() - 1);
    }
  }
}
