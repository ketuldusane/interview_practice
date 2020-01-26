import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class TestTemp {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(8);
    new TestTemp().lowestCommonAncestor(root, root.left, root.left.right.right);
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