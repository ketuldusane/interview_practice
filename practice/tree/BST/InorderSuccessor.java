package tree.BST;

import tree.TreeNode;

import java.util.Stack;

public class InorderSuccessor {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
      p = p.right;
      while (p.left != null) p = p.left;
      return p;
    }

    Stack<TreeNode> stack = new Stack<>();
    int inorder = Integer.MIN_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      if (inorder == p.val) return root;
      inorder = root.val;

      root = root.right;
    }

    return null;
  }
}
