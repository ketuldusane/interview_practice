package tree.n_ary;

import tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Preorder Traversal
 * <p>
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 * Follow up:
 * Recursive solution is trivial, could you do it iteratively?
 * <p>
 * Example 1:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * Constraints:
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */

public class PreOrderTraversal {
  public List<Integer> preorder(Node root) {
    if (root == null) return new LinkedList<>();

    Stack<Node> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      Node n = stack.pop();
      list.add(n.val);

      Collections.reverse(n.children);

      for (Node e : n.children) {
        stack.push(e);
      }
    }

    return list;
  }
}
