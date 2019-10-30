package graphs.binary_tree;

public class BinaryTree {
//  public static void main(String[] args) {
//    TreeNode<Integer> n = new TreeNode<>(1);
//    n.left = new TreeNode<>(2);
//    n.right = new TreeNode<>(3);
//
//    n.left.left = new TreeNode<>(4);
//    n.left.right = new TreeNode<>(5);
//
//    n.right.left = new TreeNode<>(6);
//    n.right.right = new TreeNode<>(7);
//
//    BinaryTree d = new BinaryTree();
//    ArrayList<LinkedList<TreeNode>> a = d.liftOfDepth(n, 0, new ArrayList<LinkedList<TreeNode<Integer>>>());
//    // d.inOrder(n);
//    // d.postOrder(n);
//    // d.preOrder(n);
//
//    // d.inOrder(d.createMinBST(new int[]{9,8,7,6,5,4,3,2,1}));
//  }
//
//  public void inOrder(TreeNode<Integer> node) {
//    if (node != null) {
//      inOrder(node.left);
//      System.out.print(" " + node.key);
//      inOrder(node.right);
//    }
//  }
//
//  public void postOrder(TreeNode<Integer> node) {
//    if (node != null) {
//      System.out.print(" " + node.key);
//      postOrder(node.left);
//      postOrder(node.right);
//    }
//  }
//
//  public void preOrder(TreeNode<Integer> node) {
//    if (node != null) {
//      preOrder(node.left);
//      preOrder(node.right);
//      System.out.print(" " + node.key);
//    }
//  }
//
//  public int isBalanced(TreeNode<Integer> node) {
//    if (node == null) return -1;
//
//    int l = isBalanced(node.left);
//    if (l == Integer.MIN_VALUE) return l;
//
//    int r = isBalanced(node.right);
//    if (r == Integer.MIN_VALUE) return r;
//
//    int max = l > r ? l : r;
//    if (Math.abs(l - r) > 1) return Integer.MIN_VALUE;
//
//    return max + 1;
//  }
//
//  public int isBST(TreeNode<Integer> node) {
//    if (node == null) return null;
//    int c = node.key;
//
//    int l, r;
//    if (node.left == null) {
//      l = Integer.MIN_VALUE;
//    } else {
//      l = isBST(node.left);
//    }
//
//    if (l > c) return Integer.MAX_VALUE;
//
//    if (node.right == null) {
//      r = Integer.MAX_VALUE;
//    } else {
//      r = isBST(node.right);
//    }
//
//    if (c > r) return Integer.MIN_VALUE;
//
//    return c;
//  }
//
//  public TreeNode<Integer> createMinBST(int[] a) {
//    return createMinBST(a, 0, a.length - 1);
//  }
//
//  public ArrayList<LinkedList<TreeNode>> liftOfDepth(TreeNode<Integer> node, int level,
//                                                     ArrayList<LinkedList<TreeNode>> a) {
//      if (node == null) return null;
//
//      LinkedList<TreeNode<Integer>> ll;
//      if (a.size() < (level + 1)) {
//        ll = new LinkedList<>();
//        a.add(ll);
//      } else {
//        ll = a.get(level);
//      }
//      ll.add(node);
//      a = liftOfDepth(node.left, level + 1, a);
//      a = liftOfDepth(node.right, level + 1, a);
//      return a;
//  }
//
//  private TreeNode<Integer> createMinBST(int[] a, int start, int end) {
//    if (end < start) return null;
//    int mid = (start + end) / 2;
//    TreeNode<Integer> n = new TreeNode<>(a[mid]);
//    n.left = createMinBST(a, start, mid - 1);
//    n.right = createMinBST(a, mid + 1, end);
//    return n;
//  }
}
