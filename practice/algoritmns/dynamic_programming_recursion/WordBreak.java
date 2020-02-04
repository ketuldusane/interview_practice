package algoritmns.dynamic_programming_recursion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 Word Break

 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input: s = "leetcode", wordDict = ["leet", "code"]
 Output: true
 Explanation: Return true because "leetcode" can be segmented as "leet code".
 Example 2:

 Input: s = "applepenapple", wordDict = ["apple", "pen"]
 Output: true
 Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output: false
 */

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    return word(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
  }

  private boolean word(String s, Set<String> wordDict, int start, Boolean[] memo) {
    if (start == s.length()) {
      return true;
    }
    if (memo[start] != null) {
      return memo[start];
    }
    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end)) && word(s, wordDict, end, memo)) {
        return memo[start] = true;
      }
    }
    return memo[start] = false;
  }
}
