package amazon.online_assesment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Substring of Size K With K Distinct Characters
 * <p>
 * Given a string s and an int k, return all unique substrings of s of size k with k distinct characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabc", k = 3
 * Output: ["abc", "bca", "cab"]
 * Example 2:
 * <p>
 * Input: s = "abacab", k = 3
 * Output: ["bac", "cab"]
 * Example 3:
 * <p>
 * Input: s = "awaglknagawunagwkwagl", k = 4
 * Output: ["wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag"]
 * Explanation:
 * Substrings in order are: "wagl", "aglk", "glkn", "lkna", "knag", "gawu", "awun", "wuna", "unag", "nagw", "agwk", "kwag", "wagl"
 * "wagl" is repeated twice, but is included in the output once.
 * Constraints:
 * <p>
 * The input string consists of only lowercase English letters [a-z]
 * 0 ≤ k ≤ 26
 */

public class SubstringOfSizeKWithKDistinctChars {
  public static void main(String[] args) {
    SubstringOfSizeKWithKDistinctChars s = new SubstringOfSizeKWithKDistinctChars();
    System.out.println(s.getSubstrings("abcabc", 3));
    System.out.println(s.getSubstrings("awaglknagawunagwkwagl", 4));
  }

  public List<String> getSubstrings(String s, int K) {
    if (s == null || s.length() < K) {
      return new ArrayList<>();
    }

    List<String> ans = new ArrayList<>();
    Set<String> seen = new HashSet<>();

    int left = 0;
    int right = 0;
    Map<Character, Integer> map = new HashMap<>();
    int counter = 0;

    while (right < s.length()) {
      char c = s.charAt(right);
      if (map.getOrDefault(c, 0) == 0) {
        counter++;
      }
      map.put(c, map.getOrDefault(c, 0) + 1);

      while (counter == K) {
        int length = right - left + 1;
        if (length == K) {
          String temp = s.substring(left, right + 1);
          if (!seen.contains(temp)) {
            seen.add(temp);
            ans.add(temp);
          }
        }
        map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
        if (map.get(s.charAt(left)) == 0) {
          counter--;
        }
        left++;
      }
      right++;
    }

    return ans;
  }
}
