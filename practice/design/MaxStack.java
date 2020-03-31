package design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Max Stack
 * <p>
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements,
 * only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */

public class MaxStack {
  private TreeMap<Integer, List<Node>> map;
  private DoubleLL stack;

  /**
   * initialize your data structure here.
   */
  public MaxStack() {
    map = new TreeMap<>();
    stack = new DoubleLL();
  }

  public void push(int x) {
    Node node = stack.add(x);
    List<Node> list = map.getOrDefault(x, new ArrayList<>());
    list.add(node);
    map.put(x, list);
  }

  public int pop() {
    int val = stack.pop();
    map.get(val).remove(map.get(val).size() - 1);
    if (map.get(val).size() == 0) {
      map.remove(val);
    }
    return val;
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return map.lastKey();
  }

  public int popMax() {
    int max = map.lastKey();
    List<Node> l = map.get(max);
    Node node = l.get(l.size() - 1);
    l.remove(node);
    if (l.size() == 0) {
      map.remove(max);
    }

    stack.remove(node);
    return max;
  }

  private static class DoubleLL {
    Node head;
    Node tail;

    DoubleLL() {
      head = new Node(-1);
      tail = new Node(-1);
      head.next = tail;
      tail.prev = head;
    }

    public Node add(int x) {
      Node node = new Node(x);
      node.next = tail;
      node.prev = tail.prev;
      tail.prev.next = node;
      tail.prev = node;
      return node;
    }

    public int pop() {
      return remove(tail.prev).val;
    }

    public int peek() {
      return tail.prev.val;
    }

    public Node remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      return node;
    }
  }

  private static class Node {
    int val;
    Node next;
    Node prev;

    Node(int v) {
      val = v;
    }
  }
}
