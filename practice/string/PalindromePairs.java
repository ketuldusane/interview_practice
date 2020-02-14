package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindrome Pairs
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation
 * of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 */

public class PalindromePairs {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> ans = new ArrayList<>();
    if (words == null || words.length < 2) {
      return ans;
    }
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
    }
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j <= words[i].length(); j++) {
        String s1 = words[i].substring(0, j);
        String s2 = words[i].substring(j);
        // if s1 = pal
        if (isPalindrome(s1)) {
          String reverseS2 = new StringBuilder(s2).reverse().toString();
          // Reverse should not be at i, consider string "aba"
          if (map.containsKey(reverseS2) && map.get(reverseS2) != i) {
            ans.add(Arrays.asList(map.get(reverseS2), i));
          }
        }
        // if s2 = palindrome
        if (isPalindrome(s2)) {
          String reverseS1 = new StringBuilder(s1).reverse().toString();
          // check not equal to zero to avoid duplicates
          if (map.containsKey(reverseS1) && map.get(reverseS1) != i && s2.length() != 0) {
            ans.add(Arrays.asList(i, map.get(reverseS1)));
          }
        }
      }
    }
    return ans;
  }

  private boolean isPalindrome(String word) {
    if (word.length() == 0) {
      return true;
    }
    int i = 0;
    int j = word.length() - 1;
    while (i <= j) {
      if (word.charAt(i) != word.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
