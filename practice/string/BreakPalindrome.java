package string;

/**
 * Break a Palindrome
 * <p>
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the
 * string becomes the lexicographically smallest possible string that isn't a palindrome.
 * <p>
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * Example 2:
 * <p>
 * Input: palindrome = "a"
 * Output: ""
 * <p>
 * Constraints:
 * <p>
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 */

public class BreakPalindrome {
  public String breakPalindrome(String palindrome) {
    char[] s = palindrome.toCharArray();
    int n = s.length;

    for (int i = 0; i < n / 2; i++) {
      if (s[i] != 'a') {
        s[i] = 'a';
        return String.valueOf(s);
      }
    }

    s[n - 1] = 'b';
    if (n < 2) {
      return "";
    }

    return String.valueOf(s);
  }
}
