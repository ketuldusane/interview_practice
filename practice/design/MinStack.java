package design;

/**
 * Min Stack
 * <p>
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * <p>
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */

public class MinStack {
  private Node head;

  /**
   * initialize your data structure here.
   */
  public MinStack() {
    head = null;
  }

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x);
    } else {
      head = new Node(x, Math.min(x, head.min), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int top() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  private static class Node {
    int val;
    int min;
    Node next;

    Node(int v, int m, Node n) {
      val = v;
      min = m;
      next = n;
    }

    Node(int v, int m) {
      val = v;
      min = m;
    }
  }
}

/*
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
