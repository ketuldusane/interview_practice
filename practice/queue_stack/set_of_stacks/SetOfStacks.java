import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks<T> {
  private ArrayList<Stack> listOfStacks = new ArrayList<>();
  private Stack<T> currentStack;
  private int capacity;

  public SetOfStacks(int capacity) {
    this.capacity = capacity;
  }

  public void push(T data) {
    Stack<T> stack = getCurrentStack();
    stack.push(data);
  }

  public T pop() {
    Stack<T> stack = getCurrentStack();
    if (stack.isEmpty())
      stack = getPreviousStack();
    T data = stack.peek();
    stack.pop();
    return data;
  }

  public T popAt(int subStack) {
    if (subStack < 0 || subStack >= listOfStacks.size())
      throw new IndexOutOfBoundsException();
    Stack<T> stack = listOfStacks.get(subStack);
    T data = stack.peek();
    stack.pop();
    leftShift(subStack);
    return data;
  }

  public T peek() {
    return getCurrentStack().peek();
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (Stack s : listOfStacks) {
      sb.append(s.toString());
      sb.append("\n");
    }
    return sb.toString();
  }

  private Stack getCurrentStack() {
    if (listOfStacks.size() == 0 || currentStack.isFull()) {
      Stack<T> stack = new Stack<T>(capacity);
      listOfStacks.add(stack);
      currentStack = stack;
    }
    return currentStack;
  }

  private Stack getPreviousStack() {
    if (listOfStacks.size() == 0 || listOfStacks.size() == 1)
      throw new EmptyStackException();
    currentStack = listOfStacks.get(listOfStacks.size() - 2);
    listOfStacks.remove(listOfStacks.size() - 1);
    return currentStack;
  }

  private void leftShift(int subStack) {
    int n = subStack;
    while (n < listOfStacks.size() - 1) {
      T data = (T) listOfStacks.get(n + 1).removeBottom();
      listOfStacks.get(n).push(data);
      n++;
    }
  }
}
