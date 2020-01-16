package string;

import java.util.*;

/**
 * Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 Example 1:

 Input:
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 Output: [0,9]
 Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 The output order does not matter, returning [9,0] is fine too.
 Example 2:

 Input:
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 Output: []
 */

public class SubstringWithConcatenationOfAllWords {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();
    if (s.length() == 0 || words.length == 0) {
      return ans;
    }

    int wordLength = words[0].length();
    int allWordsLength = words.length;
    int strLength = s.length();

    Map<String, Integer> map = new HashMap<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }

    for (int i = 0; i < strLength - (wordLength * allWordsLength) + 1; i++) {
      String sub = s.substring(i, i + wordLength * allWordsLength);
      if (isConcat(sub, map, wordLength)) {
        ans.add(i);
      }
    }

    return ans;
  }

  private boolean isConcat(String sub, Map<String, Integer> map, int wordLength) {
    Map<String, Integer> subMap = new HashMap<>();
    for (int i = 0; i < sub.length(); i += wordLength) {
      String temp = sub.substring(i, i + wordLength);
      subMap.put(temp, subMap.getOrDefault(temp, 0) + 1);
    }
    return map.equals(subMap);
  }

  public static void main(String[] args) {
    String s = "barfoofoobarthefoobarman";
    String[] words = new String[]{"bar","foo","the"};
    System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(s, words));
  }
}
