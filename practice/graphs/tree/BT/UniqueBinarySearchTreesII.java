package graphs.tree.BT;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
  public static void main(String[] args) {
    UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
    u.printTreeList(u.generateTrees(3));
  }

  public List<TreeNode> generateTrees(int n) {
    if (n <= 0) {
      return new ArrayList<TreeNode>();
    }
    return genTreeList(1, n);
  }

  private List<TreeNode> genTreeList(int start, int end) {
    List<TreeNode> l = new ArrayList<>();
    if (start > end) {
      l.add(null);
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> leftList = genTreeList(start, i - 1);
      List<TreeNode> rightList = genTreeList(i + 1, end);

      for (TreeNode left : leftList) {
        for (TreeNode right : rightList) {
          TreeNode root = new TreeNode(i);
          root.left = left;
          root.right = right;
          l.add(root);
        }
      }
    }

    return l;
  }

  private void printTreeList(List<TreeNode> l) {
    for (TreeNode treeNode : l) {
      printTree(treeNode);
      System.out.println();
    }
  }

  private void printTree(TreeNode n) {
    if (n == null) {
      System.out.print("null,");
      return;
    }
    System.out.print(n.x + ",");
    printTree(n.left);
    printTree(n.right);
  }

  static class TreeNode {
    int x;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      x = val;
    }
  }
}
