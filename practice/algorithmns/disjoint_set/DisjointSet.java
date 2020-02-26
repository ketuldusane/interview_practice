package algorithmns.disjoint_set;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a template class for Disjoint Set
 */

public class DisjointSet {
  private Map<Long, Node> map = new HashMap<>();

  private static class Node {
    long data;
    int rank;
    Node parent;
  }

  public void makeSet(long data) {
    Node node = new Node();
    node.data = data;
    node.rank = 0;
    node.parent = node;
    map.put(data, node);
  }

  public boolean union(long d1, long d2) {
    Node n1 = map.get(d1);
    Node n2 = map.get(d2);
    Node p1 = findSet(n1);
    Node p2 = findSet(n2);
    if (p1.data == p2.data) {
      return false;
    }
    if (p1.rank >= p2.rank) {
      // Only increment the rank if they are the same
      if (p1.rank == p2.rank) {
        p1.rank += 1;
      }
      p2.parent = p1;
    } else {
      p1.parent = p2;
    }
    return true;
  }

  public long findSet(long data) {
    return findSet(map.get(data)).data;
  }

  // findSet(node) returns the parent of the node
  // if the parent is not same as the node itself, that means there is a hierarchy
  // We traverse up the path and while doing, also compress the path
  private Node findSet(Node node) {
    Node parent = node.parent;
    if (parent == node) {
      return parent;
    }
    // Perform path compression
    node.parent = findSet(node.parent);
    return node.parent;
  }
}
