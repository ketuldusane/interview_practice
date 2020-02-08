package graphs.tarjans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Critical Connections in a Network
 *
 * There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections forming a network
 * where connections[i] = [a, b] represents a connection between servers a and b. Any server can reach any other server
 * directly or indirectly through the network.
 *
 * A critical connection is a connection that, if removed, will make some server unable to reach some other server.
 *
 * Return all critical connections in the network in any order.
 *
 * Example 1:
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
 * Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 */
public class CriticalConnectionsInNetwork {
  private int time = 0;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Node root = createGraph(n, connections);

    Set<Node> articulationPoints = new HashSet<>();
    Set<Node> visited = new HashSet<>();
    Map<Node, Integer> visitTime = new HashMap<>();
    Map<Node, Integer> lowTime = new HashMap<>();
    Map<Node, Node> parent = new HashMap<>();

    dfs(root, articulationPoints, visited, visitTime, lowTime, parent);

    // establish edges
    List<List<Integer>> ans = new ArrayList<>();
    List<Node> list = new ArrayList<>(articulationPoints);
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        Node a = list.get(i);
        Node b = list.get(j);
        if (a.neighbors.contains(b) || b.neighbors.contains(a)) {
          ans.add(new ArrayList<>(Arrays.asList(a.val, b.val)));
        }
      }
    }
    return ans;
  }

  private void dfs(Node node, Set<Node> art, Set<Node> visited, Map<Node, Integer> vTime, Map<Node, Integer> lTime, Map<Node, Node> parent) {
    visited.add(node);
    vTime.put(node, time);
    lTime.put(node, time);
    time++;

    int child = 0;
    boolean isArticulation = false;

    for (Node neighbor : node.neighbors) {
      // If neighbor is a parent of node
      if (neighbor == parent.get(node)) {
        continue;
      }
      // If neighbor has not been visited, then visite it
      if (!visited.contains(neighbor)) {
        parent.put(neighbor, node);
        child++;
        dfs(neighbor, art, visited, vTime, lTime, parent);

        // Check if articulation point
        if (vTime.get(node) <= lTime.get(neighbor)) {
          isArticulation = true;
        } else {
          lTime.put(node, Math.min(lTime.get(node), lTime.get(neighbor)));
        }
      } else {
        lTime.put(node, Math.min(lTime.get(node), vTime.get(neighbor)));
      }
    }

    // Collect articulation point
    if ((parent.get(node) == null && child >= 2) || (parent.get(node) != null && isArticulation)) {
      art.add(node);
    }
  }

  private Node createGraph(int n, List<List<Integer>> connections) {
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
    return nodes.get(0);
  }

  class Node {
    int val;
    List<Node> neighbors;
    Node(int v) {
      val = v;
      neighbors = new ArrayList<>();
    }
  }

  public static void main(String[] args) {
    CriticalConnectionsInNetwork c = new CriticalConnectionsInNetwork();
    // [[0,1],[1,2],[2,0],[1,3]]
    List<List<Integer>> l = new ArrayList<>();
    l.add(Arrays.asList(0, 1));
    l.add(Arrays.asList(1, 2));
    l.add(Arrays.asList(2, 0));
    l.add(Arrays.asList(1, 3));
    c.criticalConnections(4, l);
  }
}
