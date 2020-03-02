package string;

/**
 * Shortest Palindrome
 * <p>
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return
 * the shortest palindrome you can find by performing this transformation.
 * <p>
 * Example 1:
 * <p>
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: "dcbabcd"
 */

public class ShortestPalindrome {
  public String shortestPalindrome(String s) {
    return KMP(s);
  }

  // The following approach use KMP and requires O(n) time
  private String KMP(String s) {
    String temp = s + "#" + new StringBuilder(s).reverse().toString();
    int[] lookup = getLookupTable(temp);
    return new StringBuilder(s.substring(lookup[lookup.length - 1])).reverse().toString() + s;
  }

  private int[] getLookupTable(String s) {
    int[] lookup = new int[s.length()];
    int j = 0;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(j)) {
        lookup[i] = j + 1;
        j++;
      } else {
        j = lookup[i - 1];
        while (j > 0 && s.charAt(j) != s.charAt(i)) {
          j = lookup[j - 1];
        }
        if (s.charAt(j) == s.charAt(i)) {
          j++;
        }
        lookup[i] = j;
      }
    }
    return lookup;
  }

  // The following is sort of a brute force approach which requires O(n2) time
  private String brute(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(s);
    sb.reverse();

    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (s.substring(0, n - i).equals(sb.substring(i).toString())) {
        return sb.substring(0, i).toString() + s;
      }
    }
    return "";
  }
}
