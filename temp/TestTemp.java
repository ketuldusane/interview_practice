import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class TestTemp {
  public static void main(String[] args) {
    int numerator = 1;
    int denominator= 2;

    float n = (float) numerator / (float) denominator;
    String s = String.valueOf(n);
    String[] res = s.split(".");

    String dec = res[1];

    if (dec.length() == 1 && dec.charAt(0) == '0') {
      System.out.println(res[0]);
    }

    char[] d = dec.toCharArray();
    char f = d[0];
    for (int i = 1; i < d.length; i++) {
      if (d[i] != d[i - 1]) {
        System.out.println(s);
      }
    }
  }

  HashMap<TreeNode, LinkedList<TreeNode>> map = new HashMap<>();
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    generateParentMap(root);

    LinkedList<TreeNode> a = map.get(p);
    LinkedList<TreeNode> b = map.get(q);

    if (a == null || b == null) {
      return null;
    }

    HashSet<TreeNode> set = new HashSet<>(a);
    for (TreeNode n : b) {
      if (set.contains(n)) {
        return n;
      }
    }

    return null;
  }

  private void generateParentMap(TreeNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TreeNode> temp = map.getOrDefault(root, new LinkedList<>());
    LinkedList<TreeNode> l = new LinkedList<>(temp);
    l.addFirst(root);
    map.put(root, l);

    if (root.left != null) {
      map.put(root.left, l);
      generateParentMap(root.left);
    }

    if (root.right != null) {
      map.put(root.right, l);
      generateParentMap(root.right);
    }
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}