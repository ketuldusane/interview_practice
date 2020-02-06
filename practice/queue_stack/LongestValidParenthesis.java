package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Longest Valid Parenthesis
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * <p>
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */

public class LongestValidParenthesis {
  public int longestValidParentheses(String s) {
    /*
      for all the characters in string:
      0. Push -1 to the stack
      1. if char = '(', push the index on the stack
      2. if char ==')',
        - if stack is empty, push index on stack
        - get int from stack top and if the char at int is '(', pop it
      4. All the remaining int on the stack are of invalid parenthesis
      5. if stack is empty, entire string is valid
      6. if not empty, teh string between these indices is the valid string
    */

    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        stack.push(i);
      } else {
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          int x = stack.peek();
          if (x != -1 && s.charAt(x) == '(') {
            stack.pop();
          } else {
            stack.push(i);
          }
        }
      }
    }
    if (stack.isEmpty()) {
      return s.length();
    }
    int end = s.length() - 1;
    int max = 0;
    while (!stack.isEmpty()) {
      max = Math.max(max, end - stack.peek());
      end = stack.pop() - 1;
    }
    return max;
  }
}
