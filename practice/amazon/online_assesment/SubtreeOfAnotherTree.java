package amazon.online_assesment;

/**
 * Subtree of Another Tree
 * <p>
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
 * subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 * also be considered as a subtree of itself.
 * <p>
 * Example 1:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * Given tree t:
 * 4
 * / \
 * 1   2
 * Return false.
 */

public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) {
      return true;
    }

    return dfs(s, t);
  }

  private boolean dfs(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }

    if (s.val == t.val) {
      if (check(s, t)) {
        return true;
      }
    }

    return dfs(s.left, t) || dfs(s.right, t);
  }

  private boolean check(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    } else if (s == null || t == null) {
      return false;
    }

    if (s.val != t.val) {
      return false;
    }

    return check(s.left, t.left) && check(s.right, t.right);
  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int v) {
      val = v;
    }
  }
}
