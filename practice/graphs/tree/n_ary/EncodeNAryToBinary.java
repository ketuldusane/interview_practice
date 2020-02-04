package graphs.tree.n_ary;

import graphs.tree.Node;
import graphs.tree.TreeNode;

import java.util.ArrayList;

/**
 * Encode N-ary Tree to Binary Tree
 * <p>
 * Design an algorithm to encode an N-ary graphs.tree into a binary graphs.tree and decode the binary graphs.tree to get the original N-ary
 * graphs.tree. An N-ary graphs.tree is a rooted graphs.tree in which each node has no more than N children. Similarly, a binary graphs.tree is a
 * rooted graphs.tree in which each node has no more than 2 children. There is no restriction on how your encode/decode
 * algorithm should work. You just need to ensure that an N-ary graphs.tree can be encoded to a binary graphs.tree and this binary
 * graphs.tree can be decoded to the original N-nary graphs.tree structure.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by
 * the null value (See following example).
 * <p>
 * For example, you may encode the following 3-ary graphs.tree to a binary graphs.tree in this way:
 * Input: root = [1,null,3,2,4,null,5,6]
 * Note that the above is just an example which might or might not work. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Constraints:
 * <p>
 * The height of the n-ary graphs.tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */

public class EncodeNAryToBinary {
  public TreeNode encode(Node root) {
    if (root == null)
      return null;

    TreeNode newRoot = new TreeNode(root.val);
    if (root.children.size() > 0) {
      Node firstChild = root.children.get(0);
      newRoot.left = this.encode(firstChild);
    }

    TreeNode sibling = newRoot.left;
    for (int i = 1; i < root.children.size(); i++) {
      sibling.right = this.encode(root.children.get(i));
      sibling = sibling.right;
    }

    return newRoot;
  }

  // Decodes your binary graphs.tree to an n-ary graphs.tree.
  public Node decode(TreeNode root) {
    if (root == null)
      return null;

    Node newRoot = new Node(root.val, new ArrayList<Node>());
    TreeNode sibling = root.left;
    while (sibling != null) {
      newRoot.children.add(this.decode(sibling));
      sibling = sibling.right;
    }
    return newRoot;
  }
}
