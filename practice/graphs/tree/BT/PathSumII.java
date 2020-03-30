package graphs.tree.BT;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \    / \
 * 7    2  5   1
 * Return:
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */

public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    List<Integer> temp = new ArrayList<>();
    temp.add(root.val);
    backtrack(list, temp, root, root.val, sum);
    return list;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> temp, TreeNode node, int currSum, int target) {
    if (node.left == null && node.right == null) {
      if (currSum == target) {
        ans.add(new ArrayList<>(temp));
      }
    } else {
      if (node.left != null) {
        temp.add(node.left.val);
        backtrack(ans, temp, node.left, currSum + node.left.val, target);
        temp.remove(temp.size() - 1);
      }
      if (node.right != null) {
        temp.add(node.right.val);
        backtrack(ans, temp, node.right, currSum + node.right.val, target);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
