package queue_stack;

public class SortStack {
    private MyStack<Integer> primary;
    private MyStack<Integer> secondary;

    public SortStack() {
        primary = new MyStack<>();
        secondary = new MyStack<>();
    }

    public static void main(String[] args) {
        SortStack s = new SortStack();
        s.push(7);
        s.push(9);
        s.push(8);
        s.push(1);
        s.push(0);
        s.push(3);
        s.push(19);
        System.out.println(s.sort());
    }

    public void push(int data) {
        primary.push(data);
    }

    public MyStack sort() {
        while (!primary.isEmpty()) {
            int data = primary.pop();
            while (!secondary.isEmpty() && data < secondary.peek()) {
                primary.push(secondary.pop());
            }
            secondary.push(data);
        }
        copy();
        return primary;
    }

    private void copy() {
        while (!secondary.isEmpty()) {
            primary.push(secondary.pop());
        }
    }
}
