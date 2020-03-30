package graphs.tree.BT;

/**
 * Populating next right pointers in each node II
 * <p>
 * Given a binary tree
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * <p>
 * Follow up:
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,4,5,null,7]
 * Output: [1,#,2,3,#,4,5,7,#]
 * Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * Constraints:
 * The number of nodes in the given tree is less than 6000.
 * -100 <= node.val <= 100
 */

public class PopulateNextRightII {
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }

    Node node = root;
    while (node != null) {
      Node head = new Node(0);
      Node dummy = head;
      while (node != null) {
        if (node.left != null) {
          dummy.next = node.left;
          dummy = dummy.next;
        }
        if (node.right != null) {
          dummy.next = node.right;
          dummy = dummy.next;
        }
        node = node.next;
      }
      node = head.next;
    }

    return root;
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
