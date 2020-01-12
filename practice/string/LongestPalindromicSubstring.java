package string;

/**
 * Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */

public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    if (s == null || s.equals("")) {
      return "";
    }

    int start = 0;
    int end = 0;
    String ans = "";
    for (int i = 0; i < s.length(); i++) {
      String s1 = getPalindrome(s, i, i);
      String s2 = getPalindrome(s, i, i + 1);
      String maxS = s1.length() > s2.length() ? s1 : s2;
      ans = ans.length() > maxS.length() ? ans : maxS;
    }
    return ans;
  }

  private String getPalindrome(String s, int i, int j) {
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    return s.substring(i + 1, j);
  }
}
