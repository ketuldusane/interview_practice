package queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Smallest Subsequence of Distinct Characters
 * <p>
 * Return the lexicographically smallest subsequence of text that contains all the distinct characters of text exactly
 * once.
 * <p>
 * Example 1:
 * Input: "cdadabcc"
 * Output: "adbc"
 * <p>
 * Example 2:
 * Input: "abcd"
 * Output: "abcd"
 * <p>
 * Example 3:
 * Input: "ecbacba"
 * Output: "eacb"
 * <p>
 * Example 4:
 * Input: "leetcode"
 * Output: "letcod"
 * <p>
 * Constraints:
 * 1 <= text.length <= 1000
 * text consists of lowercase English letters.
 * <p>
 * Duplicate Question: https://leetcode.com/problems/remove-duplicate-letters/submissions/
 */

public class SmallestSubsequenceOfDistinctCharacters {
  // Push every character to the stack and maintain a visited cache array
  // When adding a new character, ask the previous char in stack: Do you occur again in the array?
  //  If yes, then kick the char out and continue until condition holds true
  //    Push the char
  //  If no, then push the char in
  // While performing above steps, update frequency and visited cache

  public String smallestSubsequence(String text) {
    if (text == null || text.length() < 2) {
      return text;
    }
    Deque<Character> stack = new ArrayDeque<>();
    int[] lastPos = new int[26];
    int[] visited = new int[26];

    // fill the lastPos array
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      lastPos[c - 'a'] = i;
    }

    // fill the stack
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      if (visited[c - 'a'] == 1) {
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > c && lastPos[stack.peek() - 'a'] > i) {
        visited[stack.peek() - 'a'] = 0;
        stack.pop();
      }
      visited[c - 'a'] = 1;
      stack.push(c);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }
}
