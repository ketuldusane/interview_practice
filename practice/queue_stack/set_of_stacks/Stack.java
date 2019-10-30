import java.util.EmptyStackException;

public class Stack<T> {
  private static class StackNode<T> {
    private T data;
    private StackNode next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  private StackNode<T> top = null;
  private StackNode<T> bottom = null;
  private int capacity;
  private int size;

  public Stack(int capacity) {
    this.capacity = capacity;
  }

  public void push(T data) {
    StackNode node = new StackNode(data);
    node.next = top;
    top = node;
    size++;
    if (bottom == null) bottom = top;
  }

  public T pop() {
    if (top == null)
      throw new EmptyStackException();
    T data = top.data;
    top = top.next;
    size--;
    return data;
  }

  public T peek() {
    if (top == null)
      throw new EmptyStackException();
    return top.data;
  }

  public T removeBottom() {
    if (top == null) throw new EmptyStackException();
    T data = bottom.data;
    if (top == bottom) {
      top = null;
      bottom = null;
      size = 0;
    } else {
      StackNode<T> node = top;
      while (node.next != bottom) {
        node = node.next;
      }
      node.next = null;
      bottom = node;
    }
    size--;
    return data;
  }

  public boolean isFull() {
    return size >= capacity;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    StackNode node = top;
    while (node != null) {
      stringBuilder.append(node.data + " ");
      node = node.next;
    }
    return stringBuilder.toString();
  }
}
