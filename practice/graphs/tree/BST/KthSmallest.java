package graphs.tree.BST;

import graphs.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Kth Smallest in BST
 * Given a binary search graphs.tree, write a function kthSmallest to find the kth smallest element in it.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

 Example 1:

 Input: root = [3,1,4,null,2], k = 1
 3
 / \
 1   4
 \
 2
 Output: 1
 Example 2:

 Input: root = [5,3,6,2,4,null,null,1], k = 3
 5
 / \
 3   6
 / \
 2   4
 /
 1
 Output: 3
 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */

public class KthSmallest {
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> list = new ArrayList<>();
    inorder(root, list, k);
    return list.get(k - 1);
  }

  private void inorder(TreeNode node, List<Integer> list, int k) {
    if (node == null || list.size() == k) {
      return;
    }

    if (list.size() < k) {
      inorder(node.left, list, k);
    }
    list.add(node.val);
    if (list.size() < k) {
      inorder(node.right, list, k);
    }
  }
}
