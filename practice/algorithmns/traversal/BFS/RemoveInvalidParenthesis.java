package algorithmns.traversal.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove Invalid Parenthesis
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */

public class RemoveInvalidParenthesis {
  public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    if (s == null) {
      return ans;
    }
    // Perform BFS and keep checking each generated string
    Deque<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    boolean found = false;
    queue.offer(s);
    visited.add(s);
    while (!queue.isEmpty()) {
      s = queue.poll();
      if (isValid(s)) {
        ans.add(s);
        found = true;
      }
      // if the current version is correct, we do not need to replace any more characters
      if (found) {
        continue;
      }
      for (int i = 0; i < s.length(); i++) {
        // we need to replace only parenthesis characters
        if (s.charAt(i) != '(' && s.charAt(i) != ')') {
          continue;
        }
        // ignore the current char and from a string of the remaining characters
        String t = s.substring(0, i) + s.substring(i + 1);
        if (!visited.contains(t)) {
          queue.offer(t);
          visited.add(t);
        }
      }
    }
    return ans;
  }

  // Check if a string wth parenthesis is a valid string
  // If the parenthesis are int correct order, the count at the end should be 0
  private boolean isValid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        count++;
      } else if (c == ')') {
        if (count == 0) {
          return false;
        }
        count--;
      }
    }
    return count == 0;
  }
}
