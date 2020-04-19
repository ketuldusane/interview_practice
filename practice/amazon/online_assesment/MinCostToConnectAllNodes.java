package amazon.online_assesment;

import java.util.Arrays;

/**
 * Min Cost to Connect All Nodes
 * <p>
 * OR
 * <p>
 * Min Cost to Repair Edges
 *
 * <p>
 * Given an undirected graph with n nodes labeled 1..n. Some of the nodes are already connected. The i-th edge connects
 * nodes edges[i][0] and edges[i][1] together. Your task is to augment this set of edges with additional edges to
 * connect all the nodes. Find the minimum cost to add new edges between the nodes such that all the nodes are
 * accessible from each other.
 * <p>
 * Input:
 * <p>
 * n, an int representing the total number of nodes.
 * edges, a list of integer pair representing the nodes already connected by an edge.
 * newEdges, a list where each element is a triplet representing the pair of nodes between which an edge can be added
 * and the cost of addition, respectively (e.g. [1, 2, 5] means to add an edge between node 1 and 2, the cost would be 5).
 * Example 1:
 * <p>
 * Input: n = 6, edges = [[1, 4], [4, 5], [2, 3]], newEdges = [[1, 2, 5], [1, 3, 10], [1, 6, 2], [5, 6, 5]]
 * Output: 7
 * Explanation:
 * There are 3 connected components [1, 4, 5], [2, 3] and [6].
 * We can connect these components into a single component by connecting node 1 to node 2 and node 1 to node 6 at a
 * minimum cost of 5 + 2 = 7.
 * Solution
 * Java solution using Kruskal's MST algorithm: https://leetcode.com/playground/7d5AeuFc
 * <p>
 * Related problems:
 * <p>
 * Min Cost to Repair Edges
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost (premium)
 */

public class MinCostToConnectAllNodes {
  private int[] nodes;
  private int connected;

  public static void main(String[] args) {
    MinCostToConnectAllNodes main = new MinCostToConnectAllNodes();
    int tc1 = main.minCostToConnect(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});
    if (tc1 == 7) {
      System.out.println("All Test Case Pases!");
    } else {
      System.out.println("There are test failures!");
    }
  }

  public int minCostToConnect(int n, int[][] edges, int[][] newEdges) {
    if (n <= 1) {
      return 0;
    }

    nodes = new int[n + 1];
    connected = n;

    for (int i = 0; i <= n; i++) {
      nodes[i] = i;
    }

    getNumOfConnectedNodes(edges);
    Arrays.sort(newEdges, (arr1, arr2) -> arr1[2] - arr2[2]);

    int minCost = getMinCost(newEdges);
    return connected == 1 ? minCost : -1;
  }

  private int getMinCost(int[][] edges) {
    int minCost = 0;
    for (int[] edge : edges) {
      if (union(edge[0], edge[1])) {
        minCost += edge[2];
        connected--;
      }
      if (connected == 1) {
        return minCost;
      }
    }
    return 0;
  }

  private void getNumOfConnectedNodes(int[][] edges) {
    for (int[] edge : edges) {
      if (union(edge[0], edge[1])) {
        connected--;
      }
    }
  }

  private boolean union(int a, int b) {
    int setA = find(a);
    int setB = find(b);
    if (setA != setB) {
      nodes[setB] = setA;
      return true;
    }
    return false;
  }

  private int find(int num) {
    if (nodes[num] != num) {
      nodes[num] = find(nodes[num]);
    }
    return nodes[num];
  }
}
