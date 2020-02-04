package algoritmns.sliding_window;

import java.util.Arrays;

/**
 * Longest Substring with at least K Repeating Characters

 Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

 Example 1:

 Input:
 s = "aaabb", k = 3

 Output:
 3

 The longest substring is "aaa", as 'a' is repeated 3 times.
 Example 2:

 Input:
 s = "ababbc", k = 2

 Output:
 5

 The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */

public class LongestSubstringWithAtleastKRepeatingChars {
  public int longestSubstring(String s, int k) {
    if (s == null || s.length() == 0 || k <= 0) {
      return 0;
    }

    int[] count = new int[26];
    int max = 0;
    /*
      There can be at most 26 unique characters in a substring because the string contains all lower case letters.
      Run the external for loop just to keep track of how many unique characters the substring has, and a substring is a valid substring
      if the num of characters with freq k or more is equal to the num of unique characters.
    */
    for (int i = 1; i <= 26; i++) {
      Arrays.fill(count, 0);
      int unique = 0;
      int kCount = 0;
      int start = 0;
      int end = 0;
      while (end < s.length()) {
        if (unique <= i) {
          int idx = s.charAt(end) - 'a';
          count[idx]++;
          if (count[idx] == 1) {
            unique++;
          }
          if (count[idx] == k) {
            kCount++;
          }
          end++;
        } else {
          int idx = s.charAt(start) - 'a';
          count[idx]--;
          if (count[idx] == 0) {
            unique--;
          }
          if (count[idx] == k - 1) {
            kCount--;
          }
          start++;
        }
        if (unique == i && kCount == unique) {
          max = Math.max(max, end - start);
        }
      }
    }

    return max;
  }
}
