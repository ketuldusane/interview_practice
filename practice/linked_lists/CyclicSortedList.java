package linked_lists;

public class CyclicSortedList {
  public static void main(String[] args) {
    Node n = new Node(3);
    n.next = new Node(5);
    n.next.next = new Node(1);
    n.next.next.next = n;
    CyclicSortedList c = new CyclicSortedList();
    c.insert(n, 0);
  }

  public Node insert(Node head, int insertVal) {
    Node n = new Node(insertVal);
    if (head == null) {
      n.next = n;
      return n;
    }

    if (head.next == head) {
      head.next = n;
      n.next = head;
      return head;
    }

    Node minNode = null;
    Node node = head;
    int min = Integer.MAX_VALUE;
    while (true) {
      if (node.equals(minNode))
        break;
      if (node.val < min) {
        minNode = node;
        min = node.val;
      }
      node = node.next;
    }

    node = minNode;
    while (true) {
      if ((insertVal <= node.next.val && insertVal >= node.val) || (node.next == minNode)) {
        n.next = node.next;
        node.next = n;
        break;
      }
      node = node.next;
    }

    return head;
  }

  static class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  }
}
