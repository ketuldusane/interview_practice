package queue_stack;

import java.util.Stack;

public class BasicCalculatorI {
  public int calculate(String s) {
    if (s == null || s.equals("")) return 0;

    Stack<Integer> nums = new Stack<>();
    Stack<Character> expression = new Stack<>();

    s = s.trim();
    boolean digitFound = false;

    for (int i = s.length() - 1; i >= 0; i--) {
      char token = s.charAt(i);

      if (token == ' ') continue;

      if (isExpression(token)) {
        digitFound = false;
        if (token == '(') {
          evaluateExpression(nums, expression, true);
        } else {
          expression.push(token);
        }
      } else if (Character.isDigit(token)) {
        int x = 0;
        if (digitFound) {
          x = nums.pop();
          x = x * 10 + ((int) token - '0');
        } else {
          x = ((int) token - '0');
        }
        nums.push(x);
        digitFound = true;
      }
    }

    if (expression.size() > 0) {
      evaluateExpression(nums, expression, false);
    }

    return nums.pop();
  }

  private void evaluateExpression(Stack<Integer> nums, Stack<Character> expression, boolean isBracket) {
    if (isBracket) {
      while (expression.peek() != ')') {
        evaluate(nums, expression);
      }
      if (expression.peek() == ')') expression.pop();
    } else {
      while (expression.size() > 0) {
        evaluate(nums, expression);
      }
    }
  }

  private void evaluate(Stack<Integer> nums, Stack<Character> expression) {
    int a = nums.pop();
    int b = nums.pop();
    char expr = expression.pop();
    int ans = (expr == '+') ? a + b : a - b;
    nums.push(ans);
  }

  private boolean isExpression(char token) {
    return token == '(' || token == ')' || token == '+' || token == '-';
  }

  public static void main(String[] args) {
    new BasicCalculatorI().calculate(" 2-1 + 2 ");
  }
}
