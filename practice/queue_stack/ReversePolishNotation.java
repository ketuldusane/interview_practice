package queue_stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * <p>
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there
 * won't be any divide by zero operation.
 * Example 1:
 * <p>
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */

public class ReversePolishNotation {
  public static void main(String[] args) {
    System.out.println(new ReversePolishNotation().evalRPN(
            new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
  }

  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (isOperand(token)) {
        int second = stack.pop();
        int first = stack.pop();
        int ans = performOperation(first, second, token);
        stack.push(ans);
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }

  private boolean isOperand(String sample) {
    return (sample.equals("+") || sample.equals("-") || sample.equals("*") || sample.equals("/"));
  }

  private int performOperation(int first, int second, String operand) {
    int ans = 0;
    switch (operand) {
      case "+":
        ans = first + second;
        break;
      case "/":
        ans = first / second;
        break;
      case "*":
        ans = first * second;
        break;
      case "-":
        ans = first - second;
        break;
    }
    return ans;
  }
}
