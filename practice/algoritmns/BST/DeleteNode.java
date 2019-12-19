package algoritmns.BST;

public class DeleteNode {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    if (root.val == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        root.val = successor(root.right).val;
        root.right = deleteNode(root.right, root.val);
      }
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    }

    return root;
  }

  private TreeNode successor(TreeNode root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }
}
