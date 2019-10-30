package queue_stack.set_of_stacks;

public class TestSetOfStacks {
    public static void main(String[] args) {
        SetOfStacks<String> setOfStacks = new SetOfStacks<>(3);
        setOfStacks.push("hello");
        setOfStacks.push("how");
        setOfStacks.push("are");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        // setOfStacks.push("you");
        setOfStacks.popAt(0);
        System.out.println(setOfStacks.toString());
    }
}
