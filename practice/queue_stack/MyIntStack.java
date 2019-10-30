package queue_stack;

import java.util.EmptyStackException;

public class MyIntStack {
    private static class StackNode {
        private int data;
        private StackNode next;
        private StackNode minNode;

        public StackNode(int d) {
            data = d;
        }
    }

    private StackNode top;

    public int pop() {
        if (top == null)
            throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item) {
        StackNode node = new StackNode(item);
        node.next = top;
        if (top == null) {
            node.minNode = node;
        } else if (node.data <= top.minNode.data) {
            node.minNode = node;
        } else {
            node.minNode = top.minNode;
        }
        top = node;
    }

    public int peek() {
        if (top == null)
            throw new EmptyStackException();
        return top.data;
    }

    public int min() {
        return top.minNode.data;
    }
}
