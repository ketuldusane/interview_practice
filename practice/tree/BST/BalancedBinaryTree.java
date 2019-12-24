package tree.BST;

/**
 * Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 * <p>
 * Example 1:
 * <p>
 * Given the following tree [3,9,20,null,null,15,7]:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Return true.
 * <p>
 * Example 2:
 * <p>
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * Return false.
 */

public class BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    if (root == null) return true;

    return size(root) != -1;

    // return (Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right));
  }

  private int height(TreeNode node) {
    if (node == null) return -1;

    return 1 + Math.max(height(node.left), height(node.right));
  }

  private int size(TreeNode node) {
    if (node == null) return 0;

    int l = size(node.left);
    if (l == -1) return -1;

    int r = size(node.right);
    if (r == -1) return -1;

    if (Math.abs(l - r) > 1) return -1;

    return 1 + Math.max(l, r);
  }
}
