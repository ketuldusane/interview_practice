package queue_stack;

import java.util.EmptyStackException;

public class QueueUsingStacks<T> {
    private MyStack<T> input;
    private MyStack<T> output;

    public static void main(String[] args) {
        QueueUsingStacks<Integer> queueUsingStacks = new QueueUsingStacks<>();
        queueUsingStacks.enqueue(1);
        queueUsingStacks.enqueue(2);
        System.out.println(queueUsingStacks.dequeue());
    }

    public QueueUsingStacks() {
        input = new MyStack<>();
        output = new MyStack<>();
    }

    public void enqueue(T data) {
        input.push(data);
    }

    public T dequeue() {
        checkOutput();
        return output.pop();
    }

    public T peek() {
        checkOutput();
        return output.peek();
    }

    private void checkOutput() {
        if (output.isEmpty()) {
            if (input.isEmpty()) {
                throw new EmptyStackException();
            }
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}