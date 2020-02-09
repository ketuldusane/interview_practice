package string.substring_search;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Duplicate Substring
 *
 * Company: Amazon
 *
 * Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
 * (The occurrences may overlap.)
 *
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring,
 * the answer is "".)
 *
 * Example 1:
 *
 * Input: "banana"
 * Output: "ana"
 * Example 2:
 *
 * Input: "abcd"
 * Output: ""
 *
 *
 * Note:
 *
 * 2 <= S.length <= 10^5
 * S consists of lowercase English letters.
 */

public class LongestDuplicateSubstring {
  private final int base = 26;
  private long mod = (long) Math.pow(2, 32);
  String s;

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

  private String search(int[] a, int len) {
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
        return s.substring(i, i + len);
      }
      seen.add(hash);
    }
    return "";
  }

  public String longestDupSubstring(String S) {
    if (S == null || S.length() == 0) {
      return "";
    }
    s = S;
    int start = 1;
    int end = S.length();
    String ans = "";
    int[] a = new int[S.length()];
    for (int i = 0; i < S.length(); i++) {
      a[i] = S.charAt(i) - 'a';
    }
    while (start <= end) {
      int mid = (start + end) / 2;
      String dup = search(a, mid);
      if (!dup.equals("")) {
        if (dup.length() > ans.length()) {
          ans = dup;
        }
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return ans;
  }
}
