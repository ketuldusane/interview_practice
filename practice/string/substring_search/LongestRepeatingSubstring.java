package string.substring_search;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string S, find out the length of the longest repeating substring(s). Return 0 if no repeating substring exists.
 *
 * Example 1:
 *
 * Input: "abcd"
 * Output: 0
 * Explanation: There is no repeating substring.
 * Example 2:
 *
 * Input: "abbaba"
 * Output: 2
 * Explanation: The longest repeating substrings are "ab" and "ba", each of which occurs twice.
 * Example 3:
 *
 * Input: "aabcaabdaab"
 * Output: 3
 * Explanation: The longest repeating substring is "aab", which occurs 3 times.
 * Example 4:
 *
 * Input: "aaaaa"
 * Output: 4
 * Explanation: The longest repeating substring is "aaaa", which occurs twice.
 *
 * Note:
 *
 * The string S consists of only lowercase English letters from 'a' - 'z'.
 * 1 <= S.length <= 1500
 */

public class LongestRepeatingSubstring {
  private final int base = 26;
  private long mod = (long) Math.pow(2, 32);

  private long getHash(int[] a, int len) {
    long h = 0;
    for (int i = 0; i < len; i++) {
      h = (h * base + a[i]) % mod;
    }
    return h;
  }

  private long updateHash(long h, int[] a, int start, int len, long aL) {
    h = (h * base - a[start - 1] * aL % mod + mod) % mod;
    h = (h + a[start + len - 1]) % mod;
    return h;
  }

  private int search(int[] a, int len) {
    long hash = getHash(a, len);
    Set<Long> seen = new HashSet<>();
    seen.add(hash);
    long aL = 1;
    for (int i = 1; i <= len; ++i) {
      aL = (aL * base) % mod;
    }
    for (int i = 1; i < a.length - len + 1; i++) {
      hash = updateHash(hash, a, i, len, aL);
      if (seen.contains(hash)) {
        return len;
      }
      seen.add(hash);
    }
    return -1;
  }

  // Perform binary search to find the "length" of the substring
  // For each call to search for the given length, do a Rabin-Karp substring search
  public int longestRepeatingSubstring(String S) {
    if (S == null || S.length() == 0) {
      return 0;
    }
    int n = S.length();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = S.charAt(i) - 'a';
    }
    int start = 1;
    int end = n;
    while (start <= end) {
      int mid = (start + end) / 2;
      if (search(a, mid) != -1) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start - 1;
  }

  public static void main(String[] args) {
    LongestRepeatingSubstring l = new LongestRepeatingSubstring();
    int i = l.longestRepeatingSubstring("aaabaabbbaaabaabbaabbbabbbaaaabbaaaaaabbbaabbbbbbbbbaaaabbabbaba");
    System.out.println(i);
  }
}
