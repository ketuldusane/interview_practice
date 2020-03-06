package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Valid Parenthesis String
 * <p>
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this
 * string is valid. We define the validity of a string by these rules:
 * <p>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 * Input: "()"
 * Output: True
 * Example 2:
 * Input: "(*)"
 * Output: True
 * Example 3:
 * Input: "(*))"
 * Output: True
 * Note:
 * The string size will be in the range [1, 100].
 */

public class ValidParenthesisString {
  public boolean checkValidString(String s) {
    Deque<Integer> left = new ArrayDeque<>();
    Deque<Integer> star = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left.push(i);
      } else if (s.charAt(i) == '*') {
        star.push(i);
      } else {
        if (left.isEmpty() && star.isEmpty()) {
          return false;
        }
        if (!left.isEmpty()) {
          left.pop();
        } else {
          star.pop();
        }
      }
    }
    while (!left.isEmpty() && !star.isEmpty()) {
      if (left.pop() > star.pop()) {
        return false;
      }
    }
    return left.isEmpty();
  }
}
