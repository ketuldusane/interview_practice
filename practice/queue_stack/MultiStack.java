package queue_stack;

public class MultiStack {
//  private class StackInfo {
//    public int start, size, capacity;
//    public StackInfo(int start, int defaultCapacity) {
//      this.start = start;
//      capacity = defaultCapacity;
//    }
//
//    public boolean isWithinStackCapacity(int index) {
//      if (index < 0 || index >= values.length) return false;
//      int cIndex = index < start ? index + values.length : index;
//      int end = start + capacity;
//      return start <= cIndex && cIndex < end;
//    }
//
//    public int lastElementIndex() {
//      return adjustIndex(start + size - 1);
//    }
//
//    public int lastCapacityIndex() {
//      return adjustIndex(start + capacity - 1);
//    }
//
//    public boolean isFull() { return size >= ccapacity; }
//    public boolean isEmpty() { return size == 0; }
//  }
//
//  private StackInfo[] info;
//  private int[] values;
//
//  public MultiStack(int numOfStacks, int defaultCapacity) {
//    info = new StackInfo[numOfStacks];
//    for (int i = 0; i < numOfStacks; i++) {
//      info[i] = new StackInfo(defaultCapacity * i, defaultCapacity);
//    }
//    values = new int[defaultCapacity * numOfStacks];
//  }
//
//  public void push(int stackNum, int data) throws IndexOutOfBoundsException, FullStackException {
//    if (stackNum > info.length - 1) throw new IndexOutOfBoundsException();
//    if (allStacksFull()) throw new FullStackException();
//
//    StackInfo stack = info[stackNum];
//    if (stack.isFull()) {
//      expand(stackNum);
//    }
//    stack.size++;
//    values[stack.lastElementIndex()] = data;
//  }
//
//  public int pop(int stackNum) throws EmptyStackException {
//    StackInfo stack = info[stackNum];
//    if (stack.isEmpty()) throw new EmptyStackException();
//  }
}