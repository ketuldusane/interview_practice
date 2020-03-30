package graphs.tree.BT;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Subtree of Another Tree
 *
 * Company: Amazon
 *
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a
 * subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could
 * also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */

public class SubtreeOfAnotherTree {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (t == null) {
      return true;
    }
    if (s == null) {
      return false;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(s);
    while (!stack.isEmpty()) {
      TreeNode n = stack.pop();
      if (n.val == t.val) {
        if (isSame(n, t)) {
          return true;
        }
      }
      if (n.left != null) {
        stack.push(n.left);
      }
      if (n.right != null) {
        stack.push(n.right);
      }
    }
    return false;
  }

  private boolean isSame(TreeNode a, TreeNode b) {
    if (a == null && b == null) {
      return true;
    } else if (a == null || b == null || a.val != b.val) {
      return false;
    } else {
      return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
  }

  /*

  // Another way of solving using preorder traversal and generating a string of the traversal
  // Then check whether the String for Tree t exists in the String for s or not

  public boolean isSubtree(TreeNode s, TreeNode t) {
   if (s == null && t == null) {
     return true;
   }
   if (s == null) {
     return false;
   }
   if (t == null) {
     return true;
   }
   return preorder(s, true).indexOf(preorder(t, true)) >= 0;
  }

  private String preorder(TreeNode t, boolean left) {
   if (t == null) {
     if (left) {
       return " lnull";
     } else {
       return " rnull";
     }
   }
   return " " + t.val + preorder(t.left, true) + preorder(t.right, false);
  }
  */
}
