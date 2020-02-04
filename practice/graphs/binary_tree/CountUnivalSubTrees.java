package graphs.binary_tree;

/**
 * Count Univalue Subtrees
 *
 * Given a binary graphs.tree, count the number of uni-value subtrees.
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * Example :
 * Input:  root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 * Output: 4
 */

public class CountUnivalSubTrees {
  private int count = 0;

  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) return 0;
    is_uni(root);
    return count;
  }

  private boolean is_uni(TreeNode node) {
    if (node.left == null && node.right == null) {
      count++;
      return true;
    }

    boolean is_unival = true;
    if (node.left != null) {
      is_unival = is_uni(node.left) && is_unival && (node.val == node.left.val);
    }

    if (node.right != null) {
      is_unival = is_uni(node.right) && is_unival && (node.val == node.right.val);
    }

    if (!is_unival) return false;
    count++;
    return true;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
