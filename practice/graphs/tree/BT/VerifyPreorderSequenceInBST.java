package graphs.tree.BT;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Verify Preorder Sequence in BST
 * <p>
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 * <p>
 * Consider the following binary search tree:
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * Example 1:
 * <p>
 * Input: [5,2,6,1,3]
 * Output: false
 * Example 2:
 * <p>
 * Input: [5,2,1,3,6]
 * Output: true
 * Follow up:
 * Could you do it using only constant space complexity?
 */

public class VerifyPreorderSequenceInBST {
  public boolean verifyPreorder(int[] preorder) {
    return verifyNoExtraSpace(preorder);
  }

  private boolean verifyUsingStack(int[] preorder) {
    Deque<Integer> stack = new ArrayDeque<>();
    int low = Integer.MIN_VALUE;
    for (int p : preorder) {
      if (p < low) {
        return false;
      }
      while (!stack.isEmpty() && p > stack.peek()) {
        low = stack.pop();
      }
      stack.push(p);
    }
    return true;
  }

  private boolean verifyNoExtraSpace(int[] preorder) {
    int low = Integer.MIN_VALUE;
    int i = -1;
    for (int p : preorder) {
      if (p < low) {
        return false;
      }
      while (i >= 0 && p > preorder[i]) {
        low = preorder[i];
        i--;
      }
      i++;
      preorder[i] = p;
    }
    return true;
  }
}
