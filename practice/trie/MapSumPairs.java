package trie;

import java.util.HashMap;

public class MapSumPairs {
  private Node root;
  private HashMap<String, Integer> map;

  /**
   * Initialize your data structure here.
   */
  public MapSumPairs() {
    root = new Node();
    map = new HashMap<>();
  }

  public static void main(String[] args) {
    MapSumPairs m = new MapSumPairs();
    m.insert("apple", 3);
    m.sum("ap");
    m.insert("app", 2);
    m.sum("ap");
    m.insert("app", 1);
    m.sum("ap");
  }

  public void insert(String key, int val) {
    int delta = val - map.getOrDefault(key, 0);
    map.put(key, val);
    Node curr = root;
    curr.val += delta;
    for (char c : key.toCharArray()) {
      curr.children.putIfAbsent(c, new Node());
      curr = curr.children.get(c);
      curr.val += delta;
    }
  }

  public int sum(String prefix) {
    Node curr = root;
    for (char c : prefix.toCharArray()) {
      curr = curr.children.get(c);
      if (curr == null) {
        return 0;
      }
    }
    return curr.val;
  }

  class Node {
    HashMap<Character, Node> children = new HashMap<>();
    int val = 0;
  }
}
