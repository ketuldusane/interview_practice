import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  private Map<String, GraphNode> nodes;
  private Map<GraphNode, List<GraphNode>> adjacentNodes;

  public Graph() {
    nodes = new HashMap<>();
    adjacentNodes = new HashMap<>();
  }

  public void addEddge(String data1, String data2) {
    GraphNode n1 = addNode(data1);
    GraphNode n2 = addNode(data2);

    adjacentNodes.get(n1).add(n2);
  }

  // Depth first search
  public void dfs(String data) {
    dfs(data, new HashMap<>());
    System.out.println();
  }

  // Depth first search
  public void dfs(String data, HashMap<String, Boolean> visited) {
    if (data == null || !nodes.containsKey(data))
      return;
    System.out.print(" " + data);
    visited.put(data, true);
    for (GraphNode n : adjacentNodes.get(nodes.get(data))) {
      if (!visited.containsKey(n.data)) {
        dfs(n.data, visited);
      }
    }
  }

  // Breadth first search
  public void bfs(String data) {
    HashMap<String, Boolean> visited = new HashMap<>();
    Queue<String> q = new LinkedList<>();
    GraphNode n = nodes.get(data);
    q.add(n.data);
    visited.put(data, true);

    while (!q.isEmpty()) {
      String r = q.remove();
      System.out.print(r + " ");
      for (GraphNode node : adjacentNodes.get(nodes.get(r))) {
        if (!visited.containsKey(node.data)) {
          visited.put(node.data, true);
          q.add(node.data);
        }
      }
    }
  }

  public boolean isTherePath(String start, String stop) {
    return search(start, stop, new HashMap<>());
  }

  private boolean search(String start, String stop, HashMap<String, Boolean> visited) {
    if (start.equals(stop)) {
      return true;
    }
    Queue<String> q = new LinkedList<>();
    visited.put(start, true);
    q.add(start);

    while (!q.isEmpty()) {
      String r = q.remove();
      for (GraphNode n : adjacentNodes.get(nodes.get(r))) {
        if (n.data.equals(stop)) {
          return true;
        }
        if (!visited.containsKey(n.data)) {
          visited.put(n.data, true);
          q.add(n.data);
        }
      }
    }
    return false;
  }

  private GraphNode addNode(String data) {
    if (!nodes.containsKey(data)) {
      GraphNode n = new GraphNode(data);
      nodes.put(data, n);
      adjacentNodes.put(n, new ArrayList<>());
      return n;
    } else {
      return nodes.get(data);
    }
  }
}
