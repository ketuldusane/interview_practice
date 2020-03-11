package graphs.tree.n_ary;

import graphs.tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * N-ary Tree Level Order Traversal
 * <p>
 * Given an n-ary graphs.tree, return the level order traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [[1],[3,2,4],[5,6]]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 * <p>
 * Constraints:
 * <p>
 * The height of the n-ary graphs.tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */

public class LevelOrderTraversal {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Deque<Node> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      List<Integer> level = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node node = queue.poll();
        level.add(node.val);
        queue.addAll(node.children);
      }
      result.add(level);
    }
    return result;
  }
}
