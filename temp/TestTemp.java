import clone.simple.Test;

import java.util.HashMap;

class TestTemp {
  class Node {
    HashMap<Character, Node> map;
    int val = 0;
    int childSum = 0;
  }

  private Node root;

  /** Initialize your data structure here. */
  public TestTemp() {
    root = new Node();
  }

  public void insert(String key, int val) {
    Node node = root;
    for (char c : key.toCharArray()) {
      if (!node.map.containsKey(c)) {
        node.map.put(c, new Node());
      }
      node = node.map.get(c);
      node.childSum += val;
    }
    node.val = val;
  }

  public int sum(String prefix) {
    Node node = root;
    int sum = 0;
    for (char c : prefix.toCharArray()) {
      if (!node.map.containsKey(c)) {
        return 0;
      }
      node = node.map.get(c);
    }
    return node.childSum;
  }

  public static void main(String[] args) {
    TestTemp t = new TestTemp();
    t.insert("apple", 3);
    t.sum("ap");
    t.insert("app", 2);
    t.sum("ap");
  }
}