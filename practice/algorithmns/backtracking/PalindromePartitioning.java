package algorithmns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Palindrome Partitioning
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */

public class PalindromePartitioning {
  public List<List<String>> partition(String s) {
    List<List<String>> list = new ArrayList<>();
    backtrack(list, new ArrayList<String>(), s, 0);
    return list;
  }

  private void backtrack(List<List<String>> list, List<String> temp, String s, int start) {
    if (start == s.length()) {
      list.add(new ArrayList<>(temp));
    } else {
      for (int i = start; i < s.length(); i++) {
        if (isPalindrome(s, start, i)) {
          temp.add(s.substring(start, i + 1));
          backtrack(list, temp, s, i + 1);
          temp.remove(temp.size() - 1);
        }
      }
    }
  }

  private boolean isPalindrome(String s, int l, int r) {
    while (l < r) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
}
