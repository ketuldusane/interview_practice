package amazon.online_assesment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Generate Parenthesis
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */

public class GenerateParenthesis {
  private List<String> output = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    generate("", 0, 0, n);
    return output;
  }

  private void generate(String s, int open, int close, int n) {
    if (s.length() == n * 2) {
      // if (isValid(s)) {
      output.add(s);
      // }
      return;
    }

    if (open < n)
      generate(s + "(", open + 1, close, n);
    if (close < open)
      generate(s + ")", open, close + 1, n);
  }

  private boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        }
        stack.pop();
      }
    }
    return stack.isEmpty();
  }
}
