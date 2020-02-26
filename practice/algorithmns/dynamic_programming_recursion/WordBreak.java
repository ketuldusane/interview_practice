package algorithmns.dynamic_programming_recursion;

import java.util.*;

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
    // recursion using memoization
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

  // Another solution using BFS
  private boolean findWordBreak(String s, List<String> wordDict) {
    if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
      return false;
    }
    Set<String> dict = new HashSet<>(wordDict);
    Deque<Integer> queue = new ArrayDeque<>();
    int[] visited = new int[s.length()];
    queue.offer(0);
    while (!queue.isEmpty()) {
      int start = queue.poll();
      if (visited[start] == 0) {
        for (int end = start + 1; end <= s.length(); end++) {
          if (dict.contains(s.substring(start, end))) {
            queue.offer(end);
            if (end == s.length()) {
              return true;
            }
          }
        }
        visited[start] = 1;
      }
    }
    return false;
  }
}
