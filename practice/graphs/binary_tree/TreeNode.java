public class TreeNode<T> {
  public T key;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(T key) {
    this.key = key;
    left = right = null;
  }
}
