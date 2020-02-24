package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Score of Parenthesis
 * <p>
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: 1
 * Example 2:
 * <p>
 * Input: "(())"
 * Output: 2
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: 2
 * Example 4:
 * <p>
 * Input: "(()(()))"
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */

public class ScoreOfParenthesis {
  public int scoreOfParentheses(String S) {
    int ans = 0;
    if (S == null || S.length() == 0 || S.length() % 2 == 1) {
      return ans;
    }
    Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      if (c == '(') {
        stack.push(Character.toString(c));
      } else {
        if (stack.peek().equals("(")) {
          stack.pop();
          stack.push("1");
        } else {
          int count = 0;
          while (!stack.peek().equals("(")) {
            count += Integer.parseInt(stack.pop());
          }
          stack.pop();
          stack.push(Integer.toString(2 * count));
        }
      }
    }
    while (!stack.isEmpty()) {
      ans += Integer.parseInt(stack.pop());
    }
    return ans;
  }
}
