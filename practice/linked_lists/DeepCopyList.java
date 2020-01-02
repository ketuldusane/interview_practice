package linked_lists;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 *
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the
 * list or null.
 * Return a deep copy of the list.
 *
 * Example 1:
 * Input:
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 *
 * Explanation:
 * Node 1's value is 1, both of its next and random pointer points to Node 2.
 * Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
 *
 * Note:
 *
 * You must return the copy of the given head as a reference to the cloned list.
 */

public class DeepCopyList {
  public static void main(String[] args) {
    Node n = new Node(1);
    n.next = new Node(2);
    n.next.random = n.next;
    new DeepCopyList().copyRandomList(n);
  }

  public Node copyRandomList(Node head) {
    if (head == null) return null;

    Node newHead = new Node(head.val);
    Map<Node, Node> map = new HashMap<>();
    map.put(head, newHead);

    Node node = head;
    Node newNode = newHead;
    while (node != null) {
      if (node.next != null) {
        if (map.containsKey(node.next)) {
          newNode.next = map.get(node.next);
        } else {
          newNode.next = new Node(node.next.val);
          map.put(node.next, newNode.next);
        }
      } else {
        newNode.next = null;
      }

      if (node.random != null) {
        if (map.containsKey(node.random)) {
          newNode.random = map.get(node.random);
        } else {
          newNode.random = new Node(node.random.val);
          map.put(node.random, newNode.random);
        }
      } else {
        newNode.random = null;
      }

      newNode = newNode.next;
      node = node.next;
    }

    return map.get(head);
  }

  HashMap<Node, Node> visited = new HashMap<>();

//  public Node copyRandomListRecur(Node head) {
//    if (head == null) return null;
//
//    if (visited.containsKey(head)) return  visited.get(head);
//
//    Node node = new Node(head.val);
////    node.next = copyRandomListRecur(head.ne)
//  }

  static class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int _val) { val = _val; }

    public Node(int _val,Node _next,Node _random) {
      val = _val;
      next = _next;
      random = _random;
    }
  }
}
