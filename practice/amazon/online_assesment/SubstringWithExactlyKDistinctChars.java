package amazon.online_assesment;

import java.util.HashMap;
import java.util.Map;

/**
 * Substring with exactly K distinct chars
 * <p>
 * Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k
 * distinct characters. If the given string doesn't have k distinct characters, return 0.
 * https://leetcode.com/problems/subarrays-with-k-different-integers
 * <p>
 * Example 1:
 * <p>
 * Input: s = "pqpqs", k = 2
 * Output: 7
 * Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]
 * Example 2:
 * <p>
 * Input: s = "aabab", k = 3
 * Output: 0
 * Constraints:
 * <p>
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */

public class SubstringWithExactlyKDistinctChars {
  public static void main(String[] args) {
    SubstringWithExactlyKDistinctChars s = new SubstringWithExactlyKDistinctChars();
    System.out.println(s.substringsWithExactlyKDistinctChars("pqpqs", 2));
    System.out.println(s.substringsWithExactlyKDistinctChars("aabab", 3));
  }

  public int substringsWithExactlyKDistinctChars(String s, int K) {
    int first = substringsWithAtMostK(s.toCharArray(), K);
    int second = substringsWithAtMostK(s.toCharArray(), K - 1);
    return first - second;
  }

  private int substringsWithAtMostK(char[] s, int K) {
    Map<Character, Integer> map = new HashMap<>();
    int counter = 0;
    int left = 0;
    int right = 0;
    int substrings = 0;

    while (right < s.length) {
      char c = s[right];
      if (map.getOrDefault(c, 0) == 0) {
        counter++;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);

      while (counter > K) {
        map.put(s[left], map.get(s[left]) - 1);
        if (map.get(s[left]) == 0) {
          counter--;
        }
        left++;
      }
      substrings += right - left + 1;
      right++;
    }

    return substrings;
  }
}
