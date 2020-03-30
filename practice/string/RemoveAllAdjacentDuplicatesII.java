package string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Remove all adjacent duplicates in string II
 * <p>
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them
 * causing the left and the right side of the deleted substring to concatenate together.
 * We repeatedly make k duplicate removals on s until we no longer can.
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed that the answer is unique.
 * <p>
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * <p>
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * <p>
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s only contains lower case English letters.
 */

public class RemoveAllAdjacentDuplicatesII {
  public String removeDuplicates(String s, int k) {
    return recursiveAndFast(s, k);
  }

  public String iterativeWithQueueAndSlow(String s, int k) {
    if (s == null || s.length() < k) {
      return s;
    }

    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < sb.length(); i++) {
      if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
        stack.push(1);
      } else {
        int inc = stack.pop() + 1;
        if (inc == k) {
          sb.delete(i - k + 1, i + 1);
          i = i - k;
        } else {
          stack.push(inc);
        }
      }
    }
    return sb.toString();
  }

  public String recursiveAndFast(String s, int k) {
    if (s == null || s.length() == 0) {
      return s;
    }

    int left = 0;
    int right = 0;

    while (right < s.length()) {
      while (right < s.length() && s.charAt(right) == s.charAt(left)) {
        right++;
      }
      if (right - left >= k) {
        return removeDuplicates(s.substring(0, left) + s.substring(left + k), k);
      } else {
        left = right;
      }
    }
    return s;
  }
}
