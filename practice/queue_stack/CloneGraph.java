package queue_stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 * https://leetcode.com/problems/clone-graph/
 */

public class CloneGraph {
  private HashMap<Node, Node> visited = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) return node;

    if (visited.containsKey(node)) {
      return visited.get(node);
    }

    Node cloneNode = new Node(node.val, new ArrayList<>());
    visited.put(node, cloneNode);
    for (Node neighbor : node.neighbors) {
      cloneNode.neighbors.add(cloneGraph(neighbor));
    }
    return cloneNode;
  }

  class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
