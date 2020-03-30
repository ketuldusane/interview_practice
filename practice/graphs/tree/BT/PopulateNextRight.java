package graphs.tree.BT;

/**
 * Populating Next Right Pointers in Each Node
 * You are given a perfect binary graphs.tree where all leaves are on the same level, and every parent has two children.
 * The binary graphs.tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should
 * be set to NULL. Initially, all next pointers are set to NULL.
 * <p>
 * Follow up:
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary graphs.tree (Figure A), your function should populate each next pointer to point
 * to its next right node, just like in Figure B. The serialized output is in level order as connected by the next
 * pointers, with '#' signifying the end of each level.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given graphs.tree is less than 4096.
 * -1000 <= node.val <= 1000
 */

public class PopulateNextRight {
  public Node connect(Node root) {
    if (root == null) return root;
    Node left = root.left;
    Node right = root.right;
    while (left != null) {
      left.next = right;
      left = left.right;
      right = right.left;
    }
    connect(root.left);
    connect(root.right);
    return root;
  }

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
