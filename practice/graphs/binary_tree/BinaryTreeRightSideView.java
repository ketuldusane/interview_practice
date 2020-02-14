package graphs.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Right Side View
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */

public class BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode<Integer> root) {
    List<Integer> list = new LinkedList<>();
    if (root == null) {
      return list;
    }
    List<List<TreeNode>> nodes = new ArrayList<>();
    levelOrder(root, 0, nodes);
    for (List<TreeNode> l : nodes) {
      list.add((Integer) l.get(l.size() - 1).val);
    }
    return list;
  }

  private void levelOrder(TreeNode<Integer> node, int level, List<List<TreeNode>> list) {
    if (node == null) {
      return;
    }
    if (list.size() > level) {
      list.get(level).add(node);
    } else {
      List<TreeNode> l = new ArrayList<>();
      l.add(node);
      list.add(level, l);
    }
    levelOrder(node.left, level + 1, list);
    levelOrder(node.right, level + 1, list);
  }
}
