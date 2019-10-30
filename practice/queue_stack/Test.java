public class Test {
  public static void main(String[] args) {
    tMyIntStack();
  }

  public static void tMultiStack() {
    try {
      MultiStack multiStack = new MultiStack(3, 3);
      multiStack.push(0, 1);
      multiStack.push(0, 2);
      multiStack.push(0, 3);
      multiStack.push(1, 10);
      multiStack.push(2, 20);
      multiStack.push(2, 21);
      multiStack.push(2, 22);
      multiStack.push(0, 4);
      multiStack.push(2, 23);
      System.out.println(multiStack.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void tMyIntStack() {
    MyIntStack myIntStack = new MyIntStack();
    myIntStack.push(10);
    myIntStack.push(2);
    myIntStack.push(-11);
    // myIntStack.pop();
    System.out.println(myIntStack.min());
  }
}
