package tree.n_ary;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Postorder Traversal
 * <p>
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Follow up:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [5,6,3,2,4,1]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 * <p>
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */

public class PostOrderTraversal {
  public List<Integer> postorder(Node root) {
    if (root == null) return new LinkedList<>();

    LinkedList<Integer> ans = new LinkedList<>();
    Stack<Node> stack = new Stack<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Node n = stack.pop();
      ans.addFirst(n.val);
      for (Node child : n.children) {
        stack.push(child);
      }
    }

    return ans;
  }
}
