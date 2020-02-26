package algorithmns.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 Minimum Window Substring

 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class MinimumWindowSubstring {

  /**
   * The following approach is an example of Sliding window
   * https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
   */

  public String minWindow(String s, String t) {
    if (t.length() > s.length()) {
      return "";
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c: t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int start = 0;
    int end = 0;
    int head = 0;
    int len = Integer.MAX_VALUE;
    int counter = map.size();

    while (end < s.length()) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          counter--;
        }
      }
      end++;

      while (counter == 0) {
        char tempC = s.charAt(start);
        if (map.containsKey(tempC)) {
          map.put(tempC, map.get(tempC) + 1);
          if (map.get(tempC) > 0) {
            counter++;
          }
        }

        if ((end - start) < len) {
          len = end - start;
          head = start;
        }
        start++;
      }
    }

    if (len == Integer.MAX_VALUE) {
      return "";
    }
    return s.substring(head, head + len);
  }
}
