package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorI {
  public int calculate(String s) {
    int num = 0;
    int power = 0;
    Deque<Object> stack = new ArrayDeque<>();

    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num += (int) Math.pow(10, power) * (int) (c - '0');
        power++;
      } else if (c != ' ') {
        if (power != 0) {
          stack.push(num);
          num = 0;
          power = 0;
        }
        if (c == '(') {
          int res = compute(stack);
          stack.pop();
          stack.push(res);
        } else {
          stack.push(c);
        }
      }
    }

    if (power != 0) {
      stack.push(num);
    }

    return compute(stack);
  }

  private int compute(Deque<Object> stack) {
    int res = 0;
    if (!stack.isEmpty()) {
      res = (int) stack.pop();
    }
    while (!stack.isEmpty() && !((char) stack.peek() == ')')) {
      char sign = (char) stack.pop();
      if (sign == '+') {
        res += (int) stack.pop();
      } else {
        res -= (int) stack.pop();
      }
    }
    return res;
  }

  public static void main(String[] args) {
    new BasicCalculatorI().calculate("2147483647");
  }
}
