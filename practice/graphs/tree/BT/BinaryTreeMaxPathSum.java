package graphs.tree.BT;

import graphs.tree.TreeNode;

/**
 * Binary Tree Max Path Sum
 *
 * Given a non-empty binary graphs.tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the graphs.tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:

 Input: [1,2,3]

 1
 / \
 2   3

 Output: 6
 Example 2:

 Input: [-10,9,20,null,null,15,7]

 -10
 / \
 9  20
 /  \
 15   7

 Output: 42
 */

public class BinaryTreeMaxPathSum {
  int maxsum = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    sum(root);
    return maxsum;
  }

  /** a valid path is a "straight line" that connects all the nodes, in other words, it can't "fork"
   Remember: A path cannot be divided in to two paths. So, if the path started at parent, a node cannot have bothe the childs in the path.
   */
  private int sum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = Math.max(sum(root.left), 0);
    int right = Math.max(sum(root.right), 0);

    int path_sum = root.val + left + right;
    maxsum = Math.max(path_sum, maxsum);

    return root.val + Math.max(left, right);
  }
}
