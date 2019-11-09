package queue_stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 */

public class ValidParanthesis {
  public static void main(String[] argss) {
    System.out.println(new ValidParanthesis().isValid("()()[]"));
  }

  public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (openParenthesis(c)) {
        stack.push(c);
      } else if (closedParanthesis(c)) {
        if (!checkParanthesis(c, stack)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  private boolean openParenthesis(char c) {
    return (c == '{' || c == '(' || c == '[');
  }

  private boolean closedParanthesis(char c) {
    return (c == '}' || c == ')' || c == ']');
  }

  private boolean checkParanthesis(char close, Stack<Character> stack) {
    if (stack.isEmpty()) return false;

    char open = stack.pop();
    if (close == '}' && open == '{') return true;
    if (close == ']' && open == '[') return true;
    if (close == ')' && open == '(') return true;

    return false;
  }
}
