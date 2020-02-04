package graphs.tree.BT;

import graphs.tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary graphs.tree, find the lowest common ancestor (LCA) of two given nodes in the graphs.tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 Given the following binary graphs.tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

 Example 1:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 Output: 3
 Explanation: The LCA of nodes 5 and 1 is 3.
 Example 2:

 Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 Output: 5
 Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


 Note:

 All of the nodes' values will be unique.
 p and q are different and both values will exist in the binary graphs.tree.
 */

public class LowestCommonAncestorOfBT {
  HashMap<TreeNode, TreeNode> map = new HashMap<>();
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    generateParentMap(root);

    HashSet<TreeNode> set = new HashSet<>();
    while (p != null) {
      set.add(p);
      p = map.get(p);
    }

    while (!set.contains(q)) {
      q = map.get(q);
    }

    return q;
  }

  private void generateParentMap(TreeNode root) {
    if (root == null) {
      return;
    }
    if (!map.containsKey(root)) {
      map.put(root, null);
    }
    if (root.left != null) {
      map.put(root.left, root);
      generateParentMap(root.left);
    }

    if (root.right != null) {
      map.put(root.right, root);
      generateParentMap(root.right);
    }
  }
}
