package algorithmns.dynamic_programming_recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Word Break II
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

 Note:

 The same word in the dictionary may be reused multiple times in the segmentation.
 You may assume the dictionary does not contain duplicate words.
 Example 1:

 Input:
 s = "catsanddog"
 wordDict = ["cat", "cats", "and", "sand", "dog"]
 Output:
 [
 "cats and dog",
 "cat sand dog"
 ]
 Example 2:

 Input:
 s = "pineapplepenapple"
 wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 Output:
 [
 "pine apple pen apple",
 "pineapple pen apple",
 "pine applepen apple"
 ]
 Explanation: Note that you are allowed to reuse a dictionary word.
 Example 3:

 Input:
 s = "catsandog"
 wordDict = ["cats", "dog", "sand", "and", "cat"]
 Output:
 []
 */

public class WordBreakII {
  public List<String> wordBreak(String s, List<String> wordDict) {
    return word(s, new HashSet<>(wordDict), 0);
  }

  HashMap<Integer, List<String>> memo = new HashMap<>();

  private List<String> word(String s, Set<String> dict, int start) {
    if (memo.containsKey(start)) {
      return memo.get(start);
    }
    List<String> res = new LinkedList<>();
    if (start == s.length()) {
      res.add("");
    }
    for (int end = start + 1; end <= s.length(); end++) {
      if (dict.contains(s.substring(start, end))) {
        List<String> list = word(s, dict, end);
        for (String l : list) {
          res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
        }
      }
    }
    memo.put(start, res);
    return res;
  }
}
