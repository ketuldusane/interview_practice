package graphs.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Validate Binary Tree Nodes
 *
 * You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.
 *
 * If node i has no left child then leftChild[i] will equal -1, similarly for the right child.
 *
 * Note that the nodes have no values and that we only use the node numbers in this problem.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
 * Output: false
 * Example 3:
 *
 *
 *
 * Input: n = 2, leftChild = [1,0], rightChild = [-1,-1]
 * Output: false
 * Example 4:
 *
 *
 *
 * Input: n = 6, leftChild = [1,-1,-1,4,-1,-1], rightChild = [2,-1,-1,5,-1,-1]
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 * leftChild.length == rightChild.length == n
 * -1 <= leftChild[i], rightChild[i] <= n - 1
 */

public class ValidateBinaryTreeNodes {
  // Check kthat root has 0 incoming edges and other have exactly 1
  public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.put(i, 0);
    }
    for (int i = 0; i < n; i++) {
      if (leftChild[i] >= 0) {
        map.put(leftChild[i], map.get(leftChild[i]) + 1);
      }
      if (rightChild[i] >= 0) {
        map.put(rightChild[i], map.get(rightChild[i]) + 1);
      }
    }
    // find root and check each node has indegree 1
    int root = 0;
    for (int i = 0; i < n; i++) {
      if (map.get(i) == 0) {
        root++;
      } else if (map.get(i) != 1) {
        return false;
      }
    }
    return root == 1;
  }
}
