package graphs.tree.BT;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Binary Tree Vertical Order Traversal
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * <p>
 * Output:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Examples 2:
 * <p>
 * Input: [3,9,8,4,0,1,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Examples 3:
 * <p>
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 */

public class BinaryTreeVerticalOrderTraversal {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    int[] range = new int[]{0, 0};
    getRange(root, range, 0);

    for (int i = range[0]; i <= range[1]; i++) {
      ans.add(new ArrayList<>());
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    Deque<Integer> col = new ArrayDeque<>();

    queue.offer(root);
    col.offer(-range[0]);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        int level = col.poll();

        ans.get(level).add(node.val);

        if (node.left != null) {
          queue.offer(node.left);
          col.offer(level - 1);
        }
        if (node.right != null) {
          queue.offer(node.right);
          col.offer(level + 1);
        }
      }
    }

    return ans;
  }

  private void getRange(TreeNode node, int[] range, int level) {
    if (node == null) {
      return;
    }
    range[0] = Math.min(range[0], level);
    range[1] = Math.max(range[1], level);

    getRange(node.left, range, level - 1);
    getRange(node.right, range, level + 1);
  }
}
