package graphs.tree.BT;

import java.util.HashMap;
import java.util.Map;

/**
 * Maximum Width of Binary Tree
 * <p>
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in
 * the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * <p>
 * Note: Answer will in the range of 32-bit signed integer.
 */

public class MaximumWidthOfBinaryTree {
  private int ans;
  private Map<Integer, Integer> map;

  public int widthOfBinaryTree(TreeNode root) {
    ans = 0;
    map = new HashMap<>();
    dfs(root, 0, 0);
    return ans;
  }

  private void dfs(TreeNode root, int depth, int pos) {
    if (root == null) {
      return;
    }
    map.putIfAbsent(depth, pos);
    ans = Math.max(ans, pos - map.get(depth) + 1);
    dfs(root.left, depth + 1, 2 * pos);
    dfs(root.right, depth + 1, 2 * pos + 1);
  }
}
