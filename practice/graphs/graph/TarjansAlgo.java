package graphs.graph;

import java.util.*;

/**
 *
 * Find articulation points in connected undirected graph.
 * Articulation points are vertices such that removing any one of them disconnects the graph.
 *
 * We need to do DFS of this graph and keep visitedTime and lowTime for each vertex.
 * lowTime is keeps track of back edges.
 *
 * If any one of following condition meets then vertex is articulation point.
 *
 * 1) If vertex is root of DFS and has atlesat 2 independent children.(By independent it means they are
 * not connected to each other except via this vertex). This condition is needed because if we
 * started from corner vertex it will meet condition 2 but still is not an articulation point. To filter
 * out those vertices we need this condition.
 *
 * 2) It is not root of DFS and if visitedTime of vertex <= lowTime of any adjacent vertex then its articulation point.
 *
 * Time complexity is O(E + V)
 * Space complexity is O(V)
 *
 * References:
 * https://en.wikipedia.org/wiki/Biconnected_component
 * http://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 */

public class TarjansAlgo {

  private int time = 0;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    List<List<Integer>> criticalNodes = new ArrayList<>();
    if (connections == null || connections.size() == 0) {
      return criticalNodes;
    }
    Node root = createGraph(connections);
    findCriticalConnections(criticalNodes, root);
    return criticalNodes;
  }

  private void findCriticalConnections(List<List<Integer>> criticalNodes, Node root) {
    Set<Node> visited = new HashSet<>();
    Map<Node, Integer> visitedTime = new HashMap<>();
    Map<Node, Integer> lowTime = new HashMap<>();

    HashMap<Node, Node> parent = new HashMap<>();
    find(criticalNodes, visited, visitedTime, lowTime, parent, root);
  }

  private void find(List<List<Integer>> criticalNodes, Set<Node> visited, Map<Node, Integer> visitedTime, Map<Node, Integer> lowTime, HashMap<Node, Node> parent, Node node) {
    visited.add(node);
    visitedTime.put(node, time);
    lowTime.put(node, time);
    time++;
    int adjCount = 0;
    for (Node adj : node.neighbours) {
      if (adj.equals(parent.get(node))) {
        continue;
      }
      if (!visited.contains(adj)) {
        parent.put(adj, node);
        adjCount++;
        find(criticalNodes, visited, visitedTime, lowTime, parent, adj);

        if (visitedTime.get(node) <= visitedTime.get(adj)) {
          List<Integer> temp = new ArrayList<>();
          temp.add(node.val);
          temp.add(adj.val);
          criticalNodes.add(temp);
        } else {
          lowTime.put(node, Math.min(lowTime.get(node), lowTime.get(adj)));
        }
      }
    }
//    if ((parent.get(node) == null && adjCount >= 2) || (parent.get(node) != null))
  }

  private Node createGraph(List<List<Integer>> connections) {
    HashMap<Integer, Node> nodes = new HashMap<>();
    for (List<Integer> connection : connections) {
      int a = connection.get(0);
      int b = connection.get(1);
      Node first = nodes.containsKey(a) ? nodes.get(a) : new Node(a);
      Node second = nodes.containsKey(b) ? nodes.get(b) : new Node(b);
      nodes.put(a, first);
      nodes.put(b, second);
      first.neighbours.add(second);
      second.neighbours.add(first);
    }
    return nodes.get(nodes.keySet().iterator().next());
  }

  class Node {
    int val;
    Set<Node> neighbours;
    Node(int v) {
      val = v;
      neighbours = new HashSet<>();
    }
  }

  public static void main(String[] args) {
    TarjansAlgo t = new TarjansAlgo();
    List<List<Integer>> l = new ArrayList<>();
    l.add(new ArrayList<>(Arrays.asList(0, 1)));
    l.add(new ArrayList<>(Arrays.asList(1, 2)));
    l.add(new ArrayList<>(Arrays.asList(2, 0)));
    l.add(new ArrayList<>(Arrays.asList(1, 3)));
    System.out.println(t.criticalConnections(4, l));
  }
}
