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

    int[] nums = {2,0,2,1,1,0};

    int[] vals = new int[3];
    for (int i = 0; i < nums.length; i++) {
      vals[0] = nums[i] == 0 ? vals[0] += 1 : vals[0];
      vals[1] = nums[i] == 1 ? vals[1] += 1 : vals[1];
      vals[2] = nums[i] == 2 ? vals[2] += 1 : vals[2];
    }

    int pointer = 0;
    for (int i = 0; i < nums.length; i++) {
      if (vals[pointer] == 0) {
        pointer++;
      }
      nums[i] = pointer;
      vals[pointer]--;
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}