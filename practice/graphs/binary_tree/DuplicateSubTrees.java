package graphs.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Duplicate Subtrees
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 * Therefore, you need to return above trees' root in the form of a list.
 */

public class DuplicateSubTrees {
  private Map<String, Integer> count;
  private List<TreeNode> ans;

  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.left.left = new TreeNode(4);

    node.right = new TreeNode(3);
    node.right.left = new TreeNode(2);
    node.right.left.left = new TreeNode(4);
    node.right.right = new TreeNode(4);

    System.out.println(new DuplicateSubTrees().findDuplicateSubtrees(node).toString());
  }

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    count = new HashMap<>();
    ans = new ArrayList<>();
    collect(root);
    return ans;
  }

  private String collect(TreeNode node) {
    if (node == null) return "#";
    String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
    count.put(serial, count.getOrDefault(serial, 0) + 1);
    if (count.get(serial) == 2) {
      ans.add(node);
    }
    return serial;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
