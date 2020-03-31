package algorithmns.sliding_window;

/**
 * Minimum Window Subsequence
 * <p>
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple
 * such minimum-length windows, return the one with the left-most starting index.
 * <p>
 * Example 1:
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 * <p>
 * Note:
 * All the strings in the input will only contain lowercase letters.
 * The length of S will be in the range [1, 20000].
 * The length of T will be in the range [1, 100].
 */

public class MinimumWindowSubsequence {
  public String minWindow(String S, String T) {
    if (S == null || T == null || S.length() < T.length()) {
      return "";
    }

    int right = 0;
    int len = Integer.MAX_VALUE;
    String ans = "";

    while (right < S.length()) {
      int tIndex = 0;
      while (right < S.length()) {
        if (S.charAt(right) == T.charAt(tIndex)) {
          tIndex++;
        }

        if (tIndex == T.length()) {
          break;
        }

        right++;
      }

      if (right == S.length()) {
        break;
      }

      int left = right;
      tIndex = T.length() - 1;

      while (left >= 0) {
        if (S.charAt(left) == T.charAt(tIndex)) {
          tIndex--;
        }
        if (tIndex < 0) {
          break;
        }
        left--;
      }

      if (right - left + 1 < len) {
        len = right - left + 1;
        ans = S.substring(left, right + 1);
      }

      right = left + 1;
    }

    return ans;
  }
}
