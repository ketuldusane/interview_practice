package amazon.online_assesment;

import java.util.*;

/**
 * Critical Connections in a network
 * <p>
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
 * where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server
 * directly or indirectly through the network.
 * <p>
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 * <p>
 * Return all critical connections in the network in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * n-1 <= connections.length <= 10^5
 * connections[i][0] != connections[i][1]
 * There are no repeated connections.
 */

public class CriticalConnectionsInANetwork {
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, Set<Integer>> graph = createGraph(connections);

    return findCriticalEdges(n, connections, graph);
  }

  private List<List<Integer>> findCriticalEdges(int n, List<List<Integer>> connections, Map<Integer, Set<Integer>> graph) {
    List<List<Integer>> criticalEdges = new ArrayList<>();
    Set<Integer> visited;

    for (List<Integer> connection : connections) {
      visited = new HashSet<>();

      int a = connection.get(0);
      int b = connection.get(1);

      graph.get(a).remove(b);
      graph.get(b).remove(a);

      dfs(graph, 1, visited);
      if (visited.size() != n) {
        if (a > b) {
          criticalEdges.add(Arrays.asList(b, a));
        } else {
          criticalEdges.add(Arrays.asList(a, b));
        }
      }

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    return criticalEdges;
  }

  private void dfs(Map<Integer, Set<Integer>> graph, int node, Set<Integer> visited) {
    visited.add(node);
    for (int n : graph.get(node)) {
      if (!visited.contains(n)) {
        dfs(graph, n, visited);
      }
    }
  }

  private Map<Integer, Set<Integer>> createGraph(List<List<Integer>> connections) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (List<Integer> l : connections) {
      int a = l.get(0);
      int b = l.get(1);

      graph.computeIfAbsent(a, k -> new HashSet<>());
      graph.get(a).add(b);

      graph.computeIfAbsent(b, k -> new HashSet<>());
      graph.get(b).add(a);
    }
    return graph;
  }

  /*
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    // Create a graph using the connections provided
    Map<Integer, Node> nodes = createGraph(n, connections);

    // Mark each edge as visited, and do a DFS and see if you can visit all nodes
    // If you can visit all the nodes, then this is not a critical edge
    List<List<Integer>> criticalEdges = new ArrayList<>();
    Map<Integer, Integer> testedEdges = new HashMap<>();
    for (int i = 0; i < n; i++) {
      Node node = nodes.get(i);
      Map<Integer, Integer> avoid = new HashMap<>();
      for (Node neighbor : node.neighbors) {
        if ((testedEdges.containsKey(node.val) && testedEdges.get(node.val) == neighbor.val) ||
            (testedEdges.containsKey(neighbor.val) && testedEdges.get(neighbor.val) == node.val)) {
          continue;
        }

        avoid.put(node.val, neighbor.val);
        avoid.put(neighbor.val, node.val);

        testedEdges.put(node.val, neighbor.val);
        testedEdges.put(neighbor.val, node.val);

        Set<Node> visited = new HashSet<>();
        dfs(node, avoid, visited);

        avoid.remove(node.val);
        avoid.remove(neighbor.val);

        if (visited.size() != n) {
          criticalEdges.add(Arrays.asList(node.val, neighbor.val));
        }
      }
    }
    return criticalEdges;
  }

  private void dfs(Node node, Map<Integer, Integer> avoid, Set<Node> visited) {
    visited.add(node);
    List<Node> neighbors = node.neighbors;
    for (Node neighbor : neighbors) {
      // The edge should not be in avoid map
      // The neighbor should not have been visited yet
      if ((avoid.containsKey(node.val) && avoid.get(node.val) == neighbor.val) || visited.contains(neighbor)) {
        continue;
      } else {
        dfs(neighbor, avoid, visited);
      }
    }
  }

  private Map<Integer, Node> createGraph(int n, List<List<Integer>> connections) {
    Map<Integer, Node> nodes = new HashMap<>();
    for (int i = 0; i < n; i++) {
      nodes.put(i, new Node(i));
    }
    for (List<Integer> connection : connections) {
      Node a = nodes.get(connection.get(0));
      Node b = nodes.get(connection.get(1));
      a.neighbors.add(b);
      b.neighbors.add(a);
    }
    return nodes;
  }

  private static class Node {
    int val;
    List<Node> neighbors;

    Node(int v) {
      val = v;
      neighbors = new ArrayList<>();
    }
  }
  */
}
