package amazon.online_assesment;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
  Map<Node, Node> recursiveCache = new HashMap<>();

  public Node copyRandomListRecursive(Node head) {
    if (head == null) {
      return null;
    }

    if (recursiveCache.containsKey(head)) {
      return recursiveCache.get(head);
    }

    Node node = new Node(head.val);
    node.next = copyRandomListRecursive(head.next);
    node.random = copyRandomListRecursive(head.random);

    return node;
  }

  public Node copyRandomListIterative(Node head) {
    if (head == null) {
      return null;
    }

    Map<Node, Node> cache = new HashMap<>();
    Node temp = head;

    while (temp != null) {
      Node node = new Node(temp.val);
      cache.put(temp, node);
      temp = temp.next;
    }

    temp = head;
    while (temp != null) {
      Node node = cache.get(temp);
      node.next = cache.get(temp.next);
      node.random = cache.get(temp.random);
      temp = temp.next;
    }

    return cache.get(head);
  }

  private static class Node {
    int val;
    Node next;
    Node random;

    Node(int v) {
      val = v;
    }
  }
}
