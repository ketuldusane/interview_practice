package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring with At Most Two Distinct Characters
 *
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

 Example 1:

 Input: "eceba"
 Output: 3
 Explanation: t is "ece" which its length is 3.
 Example 2:

 Input: "ccaabbb"
 Output: 5
 Explanation: t is "aabbb" which its length is 5.
 */

public class LongestSubstringAtMostTwoDistinctChar {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s == "" || s.length() == 0) {
      return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    int start = 0;
    int end = 0;
    int len = 0;
    int counter = 0;

    while (end < s.length()) {
      char c = s.charAt(end);
      map.put(c, map.getOrDefault(c, 0) + 1);
      if(map.get(c) == 1) {
        counter++;
      }
      end++;

      while (counter > 2) {
        char tempC = s.charAt(start);
        map.put(tempC, map.get(tempC) - 1);
        if (map.get(tempC) == 0) {
          counter--;
        }
        start++;
      }

      len = Math.max(len, end - start);
    }

    return len;
  }
}
