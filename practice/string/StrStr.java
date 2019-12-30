package string;

/**
 * Implement strStr()
 * <p>
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

public class StrStr {
  public int strStr(String haystack, String needle) {
    if (haystack == null) return 0;
    if (needle == null) return -1;
    if (needle.equals("")) return 0;
    if (needle.length() > haystack.length()) return -1;

    for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
      if (haystack.charAt(i) == needle.charAt(0)) {
        if (!((haystack.length() - i) < needle.length())) {
          boolean found = true;
          for (int j = 0; j < needle.length(); j++) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
              found = false;
              break;
            }
          }

          if (found) return i;
        }
      }
    }

    return -1;
  }
}
