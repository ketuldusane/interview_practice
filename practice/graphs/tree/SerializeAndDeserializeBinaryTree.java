package graphs.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Serialize and Deserialize Binary Tree
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary graphs.tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary graphs.tree can be serialized to a string and this string can be deserialized to the original graphs.tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following graphs.tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary graphs.tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

public class SerializeAndDeserializeBinaryTree {
  public static void main(String[] args) {
    SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
    TreeNode t = new TreeNode(1);
    t.left = new TreeNode(2);
    t.right = new TreeNode(3);

    String ser = s.serialize(t);
    TreeNode n = s.deserialize(ser);
  }

  // Encodes a graphs.tree to a single string.
  public String serialize(TreeNode root) {
    return ser(root, new StringBuilder()).toString();
  }

  private StringBuilder ser(TreeNode root, StringBuilder s) {
    if (root == null) {
      s.append("null,");
    } else {
      s.append(String.valueOf(root.val));
      s.append(",");
      s = ser(root.left, s);
      s = ser(root.right, s);
    }
    return s;
  }

  // Decodes your encoded data to graphs.tree.
  public TreeNode deserialize(String data) {
    String[] arr = data.split(",");
    List<String> l = new LinkedList<>(Arrays.asList(arr));
    return des(l);
  }

  private TreeNode des(List<String> l) {
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(l.get(0)));
    l.remove(0);
    root.left = des(l);
    root.right = des(l);

    return root;
  }
}
