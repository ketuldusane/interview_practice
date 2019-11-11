package queue_stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Example:

 MyStack stack = new MyStack();

 stack.push(1);
 stack.push(2);
 stack.top();   // returns 2
 stack.pop();   // returns 2
 stack.empty(); // returns false
 */

public class StackUsingQueue {
  Deque<Integer> dQueue;

  /** Initialize your data structure here. */
  public StackUsingQueue() {
    dQueue = new LinkedList<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    dQueue.offerLast(x);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    return dQueue.pollLast();
  }

  /** Get the top element. */
  public int top() {
    return dQueue.peekLast();
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return dQueue.isEmpty();
  }
}
