package tree.BST;

/**
 * Convert Sorted Array to Binary Search Tree
 * <p>
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * Given the sorted array: [-10,-3,0,5,9],
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */

public class SortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums == null || nums.length == 0) return null;

    return convert(nums, 0, nums.length - 1);
  }

  private TreeNode convert(int[] nums, int start, int end) {
    if (start > end) return null;

    int m = (start + end) / 2;
    TreeNode n = new TreeNode(nums[m]);
    n.left = convert(nums, start, m - 1);
    n.right = convert(nums, m + 1, end);

    return n;
  }
}
