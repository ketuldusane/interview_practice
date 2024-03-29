package graphs.tree.BT;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    return hasPathSum(root, sum, 0);
  }

  public boolean hasPathSum(TreeNode node, int sum, int currSum) {
    if (node == null) return false;

    if (node.left == null && node.right == null) {
      return sum == (currSum + node.val);
    }

    boolean lans = hasPathSum(node.left, sum, currSum + node.val);
    boolean rans = hasPathSum(node.right, sum, currSum + node.val);

    return lans || rans;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
