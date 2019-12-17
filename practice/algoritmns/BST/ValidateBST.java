package algoritmns.BST;

public class ValidateBST {
  public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
  }

  private boolean validate(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;

    if (min != null && node.val <= min) return false;
    if (max != null && node.val >= max) return false;

    boolean left, right;
    left = validate(node.left, min, node.val);
    right = validate(node.right, node.val, max);

    return left && right;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
