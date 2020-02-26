package algorithmns.sliding_window;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LongestSubstringWithoutRepeatingCharacters {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) return 0;
    if (s.length() == 1) return 1;
    int i = 0;
    int j = 0;
    int ans = 0;
    Set<Character> set = new HashSet<>();
    while(i < s.length() && j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j));
        j++;
        ans = Math.max(ans, j - i);
      } else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return ans;
  }
}
