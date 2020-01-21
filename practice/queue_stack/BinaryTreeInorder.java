package queue_stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
*/

public class BinaryTreeInorder {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    System.out.println(new BinaryTreeInorder().morrisTraversal(root).toString());
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    return withStack(root, new ArrayList<Integer>());
  }

  private List<Integer> withStack(TreeNode node, ArrayList<Integer> l) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = node;
    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      l.add(curr.val);
      curr = curr.right;
    }
    return l;
  }

  private List<Integer> morrisTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    TreeNode curr = root;
    TreeNode prev;
    while (curr != null) {
      if (curr.left == null) {
        ans.add(curr.val);
        curr = curr.right;
      } else {
        prev = curr.left;
        while (prev.right != null) {
          prev = prev.right;
        }
        TreeNode temp = curr;
        prev.right = curr;
        curr = curr.left;
        temp.left = null;
      }
    }
    return ans;
  }

  private List<Integer> withRecursion(TreeNode root, ArrayList<Integer> l) {
    if (root != null) {
      if (root.left != null) {
        withRecursion(root.left, l);
      }

      l.add(root.val);

      if (root.right != null) {
        withRecursion(root.right, l);
      }
    }

    return l;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
