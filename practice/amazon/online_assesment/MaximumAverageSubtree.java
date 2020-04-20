package amazon.online_assesment;

import graphs.tree.TreeNode;

/**
 * Maximum Average Subtree
 * <p>
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 * <p>
 * (A subtree of a tree is any node of that tree plus all its descendants. The average value of a tree is the sum of its values, divided by the number of nodes.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree is between 1 and 5000.
 * Each node will have a value between 0 and 100000.
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 */

public class MaximumAverageSubtree {
  private double max = (double) Integer.MIN_VALUE;

  public double maximumAverageSubtree(TreeNode root) {
    if (root == null) return 0.0;

    search(root);
    return max;
  }

  private Average search(TreeNode root) {
    if (root == null) {
      return null;
    }

    Average left = search(root.left);
    Average right = search(root.right);

    double avg = (double) root.val;
    int nodes = 1;

    if (left != null) {
      avg += left.sum;
      nodes += left.nodes;
    }

    if (right != null) {
      avg += right.sum;
      nodes += right.nodes;
    }

    max = Math.max(max, avg / nodes);
    return new Average(avg, nodes);
  }

  private static class Average {
    int nodes;
    double sum;

    public Average(double sum, int node) {
      this.sum = sum;
      this.nodes = node;
    }
  }
}
