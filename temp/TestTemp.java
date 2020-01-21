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
//    TestTemp t = new TestTemp();
//    t.insert("apple", 3);
//    t.sum("ap");
//    t.insert("app", 2);
//    t.sum("ap");
//
//    Integer[] a = {5,4,8,11,null,13,4,7,2,null,null,1};
//    TreeNode root = null, node = null;
//    for (Integer i : a) {
//      if (root == null) {
//        root = new TreeNode(i);
//      }
//    }
//    int n = 45;
//    float ans = n;
//    do {
//      ans = ans / 3;
//      if (ans == 1) {
//        System.out.println(ans);
//      }
//    } while (ans > 0);

    int n = 10;
    int l = 1;
    int r = n;
    int ans = 0;

    while (l < r) {
      int mid = (l + r) / 2;
      ans += mid;
      l = mid + 1;
    }

    System.out.println(ans);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}