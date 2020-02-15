package algoritmns.disjoint_set;

import java.util.Arrays;

/**
 * Graph Valid Tree
 *
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function
 * to check whether these edges make up a valid tree.
 *
 * Example 1:
 *
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 *
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same
 * as [1,0] and thus will not appear together in edges.
 */

public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    // Remember: There should be exact n-1 edges
    // if there are not, then the graph cannot be a tree
    if (edges.length != n - 1) {
      return false;
    }
    int[] parents = new int[n];
    Arrays.fill(parents, -1);
    for (int[] edge : edges) {
      int p1 = findSet(edge[0], parents);
      int p2 = findSet(edge[1], parents);
      if (p1 == p2) {
        return false;
      }
      parents[p2] = p1;
    }
    return true;
  }

  private int findSet(int i, int[] parents) {
    if (parents[i] == -1) {
      return i;
    }
    return parents[i] = findSet(parents[i], parents);
  }
}
