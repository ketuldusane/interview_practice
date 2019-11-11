package queue_stack;

import java.util.Stack;

/**
 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Example:

 MyQueue queue = new MyQueue();

 queue.push(1);
 queue.push(2);
 queue.peek();  // returns 1
 queue.pop();   // returns 1
 queue.empty(); // returns false
 */

public class QueueUsingStack {
  private Stack<Integer> mainStack;
  private Stack<Integer> helper;

  /** Initialize your data structure here. */
  public QueueUsingStack() {
    mainStack = new Stack<>();
    helper = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    while (!mainStack.isEmpty()) {
      helper.push(mainStack.pop());
    }

    mainStack.push(x);

    while (!helper.isEmpty()) {
      mainStack.push(helper.pop());
    }
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return mainStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return mainStack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return mainStack.isEmpty();
  }
}
