package algoritmns.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with Atmost K Distinct Characters
 *
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

 Example 1:

 Input: s = "eceba", k = 2
 Output: 3
 Explanation: T is "ece" which its length is 3.
 Example 2:

 Input: s = "aa", k = 1
 Output: 2
 Explanation: T is "aa" which its length is 2.
 */

public class LongestSubstringWithAtmostKDistinctChars {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int end = 0;
    int count = 0;
    int max = 0;
    while (end < s.length()) {
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if (map.get(c) == 1) {
        count++;
      }
      end++;

      while (count > k) {
        char e = s.charAt(start);
        if (map.containsKey(e)) {
          map.put(e, map.get(e) - 1);
          if (map.get(e) == 0) {
            count--;
            map.remove(e);
          }
          start++;
        }
      }
      max = Math.max(max, end - start);
    }
    return max;
  }
}
