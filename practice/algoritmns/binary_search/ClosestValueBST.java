package algoritmns.binary_search;

/**
 * Closest Binary Search Tree Value
 *
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 *
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *
 * Input: root = [4,2,5,1,3], target = 3.714286
 *
 *     4
 *    / \
 *   2   5
 *  / \
 * 1   3
 *
 * Output: 4
 */

public class ClosestValueBST {
  public int closestValue(TreeNode root, double target) {
    return find(root, target).v;
  }

  // O(log(H)) time, where H = height
  private int closestValueFast(TreeNode root, double target) {
    int val, closest = root.val;
    while (root != null) {
      val = root.val;
      closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
      root = target < root.val ? root.left : root.right;
    }
    return closest;
  }

  // O(n) solution
  private Dinfo find(TreeNode node, double target) {
    if (node == null) {
      return new Dinfo(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
    }

    Dinfo l = find(node.left, target);
    Dinfo r = find(node.right, target);

    double dist = Math.abs(node.val - target);
    Dinfo small = new Dinfo(node.val, dist, false);
    if (!l.leaf && small.d > l.d) small = l;
    if (!r.leaf && small.d > r.d) small = r;

    return small;
  }

  static class Dinfo {
    int v;
    double d;
    boolean leaf;
    Dinfo(int _v, double _d, boolean _l) {
      v = _v;
      d = _d;
      leaf = _l;
    }
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
